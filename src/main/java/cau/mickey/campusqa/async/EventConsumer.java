package cau.mickey.campusqa.async;

import cau.mickey.campusqa.service.Redis.RedisAdapter;
import com.alibaba.fastjson.JSON;
import cau.mickey.campusqa.util.RedisKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mickey
 * 事件消费者
 */
@Service
public class EventConsumer implements InitializingBean , ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    private Map<EventType, List<EventHandler>> config = new HashMap<>();

    private ApplicationContext applicationContext;
    @Autowired
    private RedisAdapter redisAdapter;

    public void afterPropertiesSet() throws Exception {
        //把支持的事件类型加入到config中
       Map<String , EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
       if(beans!=null){
           for(Map.Entry<String, EventHandler> entry: beans.entrySet()){
               List<EventType> eventTypes=entry.getValue().getSupportEventTypes();
               for(EventType type:eventTypes){
                   if(!config.containsKey(type)){
                       config.put(type,new ArrayList<>());
                   }
                   config.get(type).add(entry.getValue());
               }
           }
       }

       //开启一个线程处理事件
       Thread thread =new Thread(new Runnable() {
           @Override
           public void run() {
               while (true){
                   String key= RedisKeyUtil.getEventQueueKey();
                   //从redis中获取列表最后一个事件
                   List<String> events =redisAdapter.brpop(0,key);
                   //System.out.println(events);
                   for(String message:events){
                       //消息队列的第一个值可能是key,返回值的原因
                       if(message.equals(key)){
                           continue;
                       }
                       EventModel eventModel= JSON.parseObject(message,EventModel.class);
                       if(!config.containsKey(eventModel.getType())){
                           logger.error("不能识别的事件");
                           continue;
                       }
                       //调用相应的事件处理器处理事件
                       for(EventHandler handler :config.get(eventModel.getType())){
                           handler.doHandle(eventModel);
                       }
                   }
               }
           }
       });
       thread.start();
    }

    //获得应用上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
          this.applicationContext=applicationContext;
    }
}
