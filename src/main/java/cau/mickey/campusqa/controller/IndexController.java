package cau.mickey.campusqa.controller;

import cau.mickey.campusqa.util.EnvContext;
import cau.mickey.campusqa.model.Question;
import cau.mickey.campusqa.model.User;
import cau.mickey.campusqa.util.PageBean;
import cau.mickey.campusqa.vo.QuestionVo;
import cau.mickey.campusqa.vo.ViewObject;
import cau.mickey.campusqa.service.CommentService;
import cau.mickey.campusqa.service.FollowService;
import cau.mickey.campusqa.service.QuestionService;
import cau.mickey.campusqa.service.UserService;
import cau.mickey.campusqa.util.CampusQaUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<ViewObject> vos = getQuestions(0,0,Integer.MAX_VALUE);
        model.addAttribute("vos", vos);
        return "index";


    }

    @RequestMapping(path={"/questions_list"}, method = {RequestMethod.GET})
    @ResponseBody
    public String getQuestionsList(Model model){

        List<Question> questionList=qeustionService.getLatestQuestion(0,0,Integer.MAX_VALUE);
        List<QuestionVo> questionVoList = new ArrayList<>();
        for(Question question:questionList){
            QuestionVo questionVo = new QuestionVo();
            User user = userService.getUser(question.getUserId());
            questionVo.setQuestion(question);
            questionVo.setUser(user);
            questionVoList.add(questionVo);
        }
       String jsonString = JSONObject.toJSONString(questionVoList);
        System.out.println(jsonString);
        return jsonString;
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
