package cau.mickey.campusqa.vo;

import cau.mickey.campusqa.model.Question;
import cau.mickey.campusqa.model.User;

public class QuestionVo {
    private User user;
    private Question question;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
