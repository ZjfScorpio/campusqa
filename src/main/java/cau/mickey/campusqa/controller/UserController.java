package cau.mickey.campusqa.controller;

import cau.mickey.campusqa.model.Comment;
import cau.mickey.campusqa.model.Question;
import cau.mickey.campusqa.model.User;
import cau.mickey.campusqa.service.CommentService;
import cau.mickey.campusqa.service.FollowService;
import cau.mickey.campusqa.service.QuestionService;
import cau.mickey.campusqa.service.UserService;
import cau.mickey.campusqa.util.CampusQaUtil;
import cau.mickey.campusqa.util.EnvContext;
import cau.mickey.campusqa.vo.ViewObject;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService qeustionService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private FollowService followService;

    @Autowired
    private EnvContext envContext;

    @RequestMapping(path = {"/user/{userId}"} , method = {RequestMethod.GET})
    public String userIndex(Model model, @PathVariable("userId") int userId){
        List<ViewObject> vos = getQuestions(userId,0,80);
        //model
        model.addAttribute("vos", vos);
        User user = userService.getUser(userId);
        User me = envContext.getUser();
        ViewObject vo = new ViewObject();
        vo.set("me",me);
        vo.set("user", user);
        vo.set("commentCount", commentService.getUserCommentCount(userId));
        vo.set("questionCount",vos.size());
        vo.set("followerCount", followService.getFollowerCount(CampusQaUtil.ENTITY_USER, userId));
        vo.set("followeeCount", followService.getFolloweeCount(userId, CampusQaUtil.ENTITY_USER));
        if (envContext.getUser() != null) {
            vo.set("followed", followService.isFollower(envContext.getUser().getId(), CampusQaUtil.ENTITY_USER, userId));
        } else {
            vo.set("followed", false);
        }
        //model
        model.addAttribute("profileUser", vo);
        return "profile";
    }

    //获取用户所有评论和评论对应的问题
    @RequestMapping(path = {"/user/{userId}/comments"}, method = {RequestMethod.GET})
    public String userComments(Model model, @PathVariable("userId") int userId) {
    //old
        List<ViewObject> vos = getQuestions(userId,0,80);
        //model
        model.addAttribute("vos", vos);
        User user = userService.getUser(userId);
        User me = envContext.getUser();
        ViewObject vo = new ViewObject();
        vo.set("me",me);
        vo.set("user", user);
        vo.set("commentCount", commentService.getUserCommentCount(userId));
        vo.set("questionCount",vos.size());
        vo.set("followerCount", followService.getFollowerCount(CampusQaUtil.ENTITY_USER, userId));
        vo.set("followeeCount", followService.getFolloweeCount(userId, CampusQaUtil.ENTITY_USER));
        if (envContext.getUser() != null) {
            vo.set("followed", followService.isFollower(envContext.getUser().getId(), CampusQaUtil.ENTITY_USER, userId));
        } else {
            vo.set("followed", false);
        }
        //model
        model.addAttribute("profileUser", vo);

    //new
        List<Comment> comments = commentService.getCommentsByUserId(userId);
        List<ViewObject> commentsVos = new ArrayList<>();
        for(Comment comment:comments){
            ViewObject vo1 = new ViewObject();
            vo1.set("comment",comment);
            vo1.set("question",qeustionService.getById(comment.getEntityId()));
            commentsVos.add(vo1);
        }
        if (envContext.getUser() != null) {
            //model
            model.addAttribute("comments", commentsVos);

        }
        return "comments";
    }

    //获取用户所有关注的问题
    @RequestMapping(path = {"/user/{userId}/follow_questions"} , method = {RequestMethod.GET})
    public String userFollowQuestions(Model model, @PathVariable("userId") int userId){
    //old
        List<ViewObject> vos = getQuestions(userId,0,2000);
        //model
        model.addAttribute("vos", vos);
        User user = userService.getUser(userId);
        User me = envContext.getUser();
        ViewObject vo = new ViewObject();
        vo.set("me",me);
        vo.set("user", user);
        vo.set("commentCount", commentService.getUserCommentCount(userId));
        vo.set("questionCount",vos.size());
        vo.set("followerCount", followService.getFollowerCount(CampusQaUtil.ENTITY_USER, userId));
        vo.set("followeeCount", followService.getFolloweeCount(userId, CampusQaUtil.ENTITY_USER));
        if (envContext.getUser() != null) {
            vo.set("followed", followService.isFollower(envContext.getUser().getId(), CampusQaUtil.ENTITY_USER, userId));
        } else {
            vo.set("followed", false);
        }
        //model
        model.addAttribute("profileUser", vo);

    //new
        List<Integer> questionsId = qeustionService.getQuestionsId();
        List<Integer> followQuestionsIds = new ArrayList<>();
        for(Integer questionId:questionsId){
            List<Integer> users = followService.getFollowers(CampusQaUtil.ENTITY_QUESTION, questionId, 200);
            for(Integer user1:users){
                if(user1==userId)
                    followQuestionsIds.add(questionId);
            }
        }
        List<Question> followQuestions = new ArrayList<>();
       if(followQuestionsIds.size()>0){
           for(Integer questionId:followQuestionsIds){
               Question question = qeustionService.getById(questionId);
               followQuestions.add(question);
           }
       }
        model.addAttribute("followQuestions", followQuestions);
        return "follow_questions";
    }


    private List<ViewObject> getQuestions(int userId, int offset,int limit){
        List<Question> questionList=qeustionService.getLatestQuestion(userId,offset,limit);
        List<ViewObject> vos =new ArrayList<>();
        for(Question question:questionList){
            ViewObject vo =new ViewObject();
            vo.set("question", question);
            vo.set("user", userService.getUser(question.getUserId()));
            vo.set("followCount", followService.getFollowerCount(CampusQaUtil.ENTITY_QUESTION, question.getId()));
            vos.add(vo);
        }
        return vos;
    }
}
