package cau.mickey.campusqa.service;

import cau.mickey.campusqa.dao.MessageDao;
import cau.mickey.campusqa.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mickey
 * 私信相关
 */
@Service
public class MessageService {
    @Autowired
    private MessageDao messageDao;

    @Autowired
    private SensitiveService sensitiveService;

    public int addMessage(Message message) {
        message.setContent(sensitiveService.filter(message.getContent()));
        return messageDao.addMessage(message) > 0 ? message.getId() : 0;
    }

    public List<Message> getConversationDetail(String conversationId, int offset, int limit) {
       return messageDao.selectConversationDetail(conversationId,offset,limit);
    }

    public List<Message> getConversationList(int userId, int offset, int limit){
        return messageDao.selectConversationList(userId,offset,limit);
    }

    public int getConversationUnreadCount(int userId,String conversationId){
        return messageDao.selectConversationUnreadCount(userId,conversationId);
    }

    public void updateHasRead(int userId, String conversationId){
        messageDao.updateHasRead(userId,conversationId);
    }
}
