package cau.mickey.campusqa.service;

import cau.mickey.campusqa.model.Comment;
import cau.mickey.campusqa.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * @author mickey
 * 回答相关
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    @Autowired
    private SensitiveService sensitiveService;
    public List<Comment> getCommentsByEntity(int entityId, int entityType){
        return commentDao.selectCommentByEntity(entityId,entityType);
    }

    public int addComment(Comment comment){
        comment.setContent(HtmlUtils.htmlEscape(comment.getContent()));
        comment.setContent(sensitiveService.filter(comment.getContent()));
        return commentDao.addComment(comment)>0?comment.getId():0;
    }

    public int getCommentCount(int entityId, int entityType){
        return commentDao.getCommentCount(entityId,entityType);
    }

    //删除评论
    public int delCommentById(int id){
        return commentDao.delQuestion(id);
    }

    public Comment getCommentById(int id){
        return commentDao.selectById(id);
    }

    public int getUserCommentCount(int userId) {
        return commentDao.getUserCommentCount(userId);
    }

}
