package cau.mickey.campusqa.async.handler;

import cau.mickey.campusqa.constant.Constant;
import cau.mickey.campusqa.model.Message;
import cau.mickey.campusqa.service.MessageService;
import cau.mickey.campusqa.service.UserService;
import cau.mickey.campusqa.async.EventHandler;
import cau.mickey.campusqa.async.EventModel;
import cau.mickey.campusqa.async.EventType;
import cau.mickey.campusqa.model.User;
import cau.mickey.campusqa.util.CampusQaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author mickey
 * 关注发送消息提醒事件
 */
@Component
public class FollowHandler  implements EventHandler {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Override
    public void doHandle(EventModel model) {
        //如果是自己给自己关注，就不给自己发私信了
        if (model.getEntityOwnerId() == model.getActorId()) {
            return;
        }
        Message message = new Message();
        message.setFromId(CampusQaUtil.FOLLOW_USER_ID);
        message.setToId(model.getEntityOwnerId());
        message.setCreatedDate(new Date());
        User user = userService.getUser(model.getActorId());
        if(model.getEntityType()== CampusQaUtil.ENTITY_QUESTION){
            message.setContent("用户 " + user.getName() +
                    " 关注了您的问题 \" "+ model.getExt("questionTitle")+ " \" <a href=\"/question/" + model.getEntityId() + "\">点击查看</a>");
        }
        else if(model.getEntityType()== CampusQaUtil.ENTITY_USER){
            message.setContent("用户 " + user.getName() +
                    " 关注了您, <a href=\""+"http://"+ Constant.IP + ":"+ Constant.PORT +"/user/" + model.getActorId() + "\">点击查看该用户主页</a>");
        }
        message.setConversationId(message.getConversationId());
        messageService.addMessage(message);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.FOLLOW);
    }
}
