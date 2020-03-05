package cau.mickey.campusqa.service.mail;

import cau.mickey.campusqa.constant.Constant;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Map;
import java.util.Properties;


/**
 * @author mickey
 * 邮箱相关配置和服务
 */
@Service
public class MailSender implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);
    private JavaMailSenderImpl mailSender;

    //发送邮件的模板引擎配置
    @Autowired
    private FreeMarkerConfigurer configurer;

    @Override
    public void afterPropertiesSet() throws Exception {
        mailSender = new JavaMailSenderImpl();
        mailSender.setUsername(Constant.USER_NAME);
        mailSender.setPassword(Constant.PASSWORD);
        mailSender.setHost(Constant.MAIL_HOST);
        //mailSender.setHost("smtp.qq.com");
        mailSender.setPort(465);
        mailSender.setProtocol("smtps");
        mailSender.setDefaultEncoding("utf8");
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.ssl.enable", true);
        //javaMailProperties.put("mail.smtp.auth", true);
        //javaMailProperties.put("mail.smtp.starttls.enable", true);
        mailSender.setJavaMailProperties(javaMailProperties);
    }

    public boolean sendWithHTMLTemplate(String to, String subject,
                                        String templateName, Map<String, Object> model) {
        try {
            String nickName = MimeUtility.encodeText(Constant.MAIL_NICKNAME);
            InternetAddress from = new InternetAddress(nickName+Constant.INTERNET_ADDRESS);
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            // String result = VelocityEngineUtils
            //        .mergeTemplateIntoString(velocityEngine, templateName, "UTF-8", model);
            Template template = configurer.getConfiguration().getTemplate(templateName);
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text, true);
            mailSender.send(mimeMessage);
            logger.info("发送邮件成功");
            return true;
        } catch (Exception e) {
            logger.error("发送邮件失败" + e.getMessage());
            return false;
        }
    }


}
