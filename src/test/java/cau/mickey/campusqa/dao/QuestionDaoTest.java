package cau.mickey.campusqa.dao;

import cau.mickey.campusqa.model.Question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class QuestionDaoTest {
    @Autowired
    QuestionDao questionDao;

    @Test
    public void addQuestion() {
        Question question = new Question();
        question.setId(1000);
        question.setTitle("电脑配置有性能过剩的说法吗");
        question.setContent("为什么电脑配置越高越好？");
        question.setCommentCount(0);
        question.setUserId(10);
        Assert.assertTrue(questionDao.addQuestion(question)>0);
    }

    @Test
    public void selectById() {
        int id = 101;
        Question question = questionDao.selectById(id);
        System.out.println("问题题目:\n"+question.getTitle());
        Assert.assertNotNull(question);
    }

    @Test
    public void updateCommentCount() {
    }

    @Test
    public void selectLatestQuestions() {
    }

    @Test
    public void delQuestion() {
        int id = 102;
        Assert.assertTrue(questionDao.delQuestion(id)>0);

    }

    @Test
    public void selectQuestionsId() {
    }
}