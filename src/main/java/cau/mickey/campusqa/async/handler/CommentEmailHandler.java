package cau.mickey.campusqa.async.handler;

import cau.mickey.campusqa.model.Question;
import cau.mickey.campusqa.service.QuestionService;
import cau.mickey.campusqa.async.EventHandler;
import cau.mickey.campusqa.async.EventModel;
import cau.mickey.campusqa.async.EventType;
import cau.mickey.campusqa.service.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mickey
 * 评论发送邮件事件
 */
@Component
public class CommentEmailHandler  implements EventHandler {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private QuestionService questionService;

    @Override
    public void doHandle(EventModel model) {
        //如果是自己给自己评论，就不给自己发邮件了
//        Question question=questionService.getById(model.getEntityId());
//        Map<String ,Object> map=new HashMap<>();
//        map.put("username", model.getExt("username"));
//        map.put("questionTitle",question.getTitle());
//        mailSender.sendWithHTMLTemplate(model.getExt("email"),"您在<在线问答平台>发布的问题有了新评论",
//                "mails/comment_email.html", map);
        return ;
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.COMMENT);
    }
}
