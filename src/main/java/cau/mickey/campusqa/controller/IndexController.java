package cau.mickey.campusqa.controller;

import cau.mickey.campusqa.util.EnvContext;
import cau.mickey.campusqa.model.Question;
import cau.mickey.campusqa.model.User;
import cau.mickey.campusqa.vo.ViewObject;
import cau.mickey.campusqa.service.CommentService;
import cau.mickey.campusqa.service.FollowService;
import cau.mickey.campusqa.service.QuestionService;
import cau.mickey.campusqa.service.UserService;
import cau.mickey.campusqa.util.CampusQaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
/**
 * @author mickey
 * 接口
 * 首页、用户信息
 */
@Controller
public class IndexController {
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

    @RequestMapping(path={"/","index"}, method = {RequestMethod.GET})
    public String index(Model model){
        List<ViewObject> vos = getQuestions(0,0,80);
        model.addAttribute("vos", vos);
        return "index";
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
