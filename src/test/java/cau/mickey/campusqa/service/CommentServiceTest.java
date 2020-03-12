package cau.mickey.campusqa.service;

import cau.mickey.campusqa.model.Comment;
import cau.mickey.campusqa.util.CampusQaUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentServiceTest {
    @Autowired
    CommentService commentService;

    @Test
    public void getCommentsByEntity() {
    }

    @Test
    public void addComment() {
        Comment comment = new Comment();
        comment.setId(1000);
        comment.setContent("我同意");
        comment.setCreatedDate(new Date());
        comment.setEntityId(12);
        comment.setEntityType(CampusQaUtil.ENTITY_COMMENT);
        comment.setUserId(100);
        comment.setStatus(0);
        Assert.assertTrue(commentService.addComment(comment)>0);
    }

    @Test
    public void getCommentCount() {
    }

    @Test
    public void delCommentById() {
        int id = 58;
        Assert.assertTrue(commentService.delCommentById(id)>0);
    }

    @Test
    public void getCommentById() {
        int id = 57;
        Comment comment = commentService.getCommentById(id);
        Assert.assertNotNull(comment);
        System.out.println("评论内容：\n"+comment.getContent());
    }

    @Test
    public void getUserCommentCount() {
    }

    @Test
    public void getCommentsByUserId() {
    }
}