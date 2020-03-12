package cau.mickey.campusqa.service;

import cau.mickey.campusqa.model.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageServiceTest {
    @Autowired
    MessageService messageService;

    @Test
    public void addMessage() {
        Message message = new Message();
        message.setId(100);
        message.setContent("你好，这是测试消息");
        message.setConversationId("20_21");
        message.setCreatedDate(new Date());
        message.setFromId(20);
        message.setToId(21);
        message.setHasRead(0);
        Assert.assertTrue(messageService.addMessage(message)>0);
    }

    @Test
    public void getConversationDetail() {
        String conversationId = "20_21";
        List<Message> messageList = messageService.getConversationDetail(conversationId,0,10);
        Assert.assertNotNull(messageList);
        System.out.println("信息:\n");
        for(Message message:messageList){
            System.out.println(message.getContent());
        }
    }

    @Test
    public void getConversationList() {
    }

    @Test
    public void getConversationUnreadCount() {
    }

    @Test
    public void updateHasRead() {
        int userId = 21;
        String conversationId = "20_21";
        messageService.updateHasRead(userId,conversationId);
    }
}