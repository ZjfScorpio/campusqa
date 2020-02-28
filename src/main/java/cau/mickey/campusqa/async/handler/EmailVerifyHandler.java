package cau.mickey.campusqa.async.handler;

import cau.mickey.campusqa.async.EventHandler;
import cau.mickey.campusqa.async.EventModel;
import cau.mickey.campusqa.async.EventType;
import cau.mickey.campusqa.constant.Constant;
import cau.mickey.campusqa.service.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mickey
 * 邮箱验证事件
 */
@Component
public class EmailVerifyHandler implements EventHandler {


    @Autowired
    private MailSender mailSender;

    @Override
    public void doHandle(EventModel model) {
        Map<String ,Object> map=new HashMap<>();
        map.put("url","http://"+ Constant.IP + ":"+ Constant.PORT +"/regVerify?p="+model.getExt("register_ticket"));
        mailSender.sendWithHTMLTemplate(model.getExt("email"),"<校园内自动知识应答平台>注册激活邮件",
                "mails/register_email.html", map);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.REGISTER);
    }
}
