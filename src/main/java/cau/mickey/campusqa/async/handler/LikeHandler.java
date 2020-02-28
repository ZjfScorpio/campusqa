package cau.mickey.campusqa.async.handler;

import cau.mickey.campusqa.constant.Constant;
import cau.mickey.campusqa.model.Message;
import cau.mickey.campusqa.model.User;
import cau.mickey.campusqa.service.MessageService;
import cau.mickey.campusqa.service.UserService;
import cau.mickey.campusqa.async.EventHandler;
import cau.mickey.campusqa.async.EventModel;
import cau.mickey.campusqa.async.EventType;
import cau.mickey.campusqa.util.CampusQaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author mickey
 * 点赞发送消息提醒事件
 */
@Component
public class LikeHandler implements EventHandler {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Override
    public void doHandle(EventModel model) {
        //如果是自己给自己点赞，就不给自己发私信了
        if (model.getEntityOwnerId() == model.getActorId()) {
            return;
        }
        Message message = new Message();
        message.setFromId(CampusQaUtil.LIKE_USER_ID);
        message.setToId(model.getEntityOwnerId());
        message.setCreatedDate(new Date());
        User user = userService.getUser(model.getActorId());
        message.setContent("用户 " + user.getName() + " 赞了你的评论, <a href=\"http://"+ Constant.IP + ":"+ Constant.PORT +"/question/" + model.getExt("questionId") + "\">点击查看该问题</a>");
        message.setConversationId(message.getConversationId());
        messageService.addMessage(message);
    }

    //本handler只处理点赞（like）类型的消息
    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LIKE);
    }
}
