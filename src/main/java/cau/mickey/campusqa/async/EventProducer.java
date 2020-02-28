package cau.mickey.campusqa.async;

import cau.mickey.campusqa.service.Redis.RedisAdapter;
import com.alibaba.fastjson.JSONObject;
import cau.mickey.campusqa.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mickey
 * 事件生产者
 */
@Service
public class EventProducer {
    @Autowired
    private RedisAdapter redisAdapter;

    //产生事件，放入到redis中
    public boolean fireEvent(EventModel eventModel) {
        try {
            String json = JSONObject.toJSONString(eventModel);
            String key = RedisKeyUtil.getEventQueueKey();
            long pushResult = redisAdapter.lpush(key, json);
//            if(pushResult>0)
//                System.out.println("事件添加到redis成功");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
