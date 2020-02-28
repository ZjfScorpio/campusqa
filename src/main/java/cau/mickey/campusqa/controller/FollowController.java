package cau.mickey.campusqa.controller;

import cau.mickey.campusqa.async.EventModel;
import cau.mickey.campusqa.async.EventProducer;
import cau.mickey.campusqa.async.EventType;
import cau.mickey.campusqa.util.EnvContext;
import cau.mickey.campusqa.model.Question;
import cau.mickey.campusqa.model.User;
import cau.mickey.campusqa.vo.ViewObject;
import cau.mickey.campusqa.service.CommentService;
import cau.mickey.campusqa.service.FollowService;
import cau.mickey.campusqa.service.QuestionService;
import cau.mickey.campusqa.service.UserService;
import cau.mickey.campusqa.util.CampusQaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mickey
 * 接口
 * 关注、粉丝、关注问题
 */
@Controller
public class FollowController {
    @Autowired
    private FollowService followService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private EnvContext envContext;

    @Autowired
    private EventProducer eventProducer;

    @RequestMapping(path = {"/followUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public String followUser(@RequestParam("userId") int userId) {
        if (envContext.getUser() == null) {
            return CampusQaUtil.getJSONString(999);
        }
        boolean ret = followService.follow(envContext.getUser().getId(), CampusQaUtil.ENTITY_USER, userId);
        eventProducer.fireEvent(new EventModel(EventType.FOLLOW)
                .setActorId(envContext.getUser().getId())
                .setEntityId(userId)
                .setEntityOwnerId(userId)
                .setEntityType(CampusQaUtil.ENTITY_USER));
        return CampusQaUtil.getJSONString(ret ? 0 : 1, String.valueOf(followService.getFolloweeCount(envContext.getUser().getId(), CampusQaUtil.ENTITY_USER)));
    }

    @ResponseBody
    @RequestMapping(path = {"/unfollowUser"}, method = {RequestMethod.POST})
    public String unfollowUser(@RequestParam("userId") int userId) {
        if (envContext.getUser() == null) {
            return CampusQaUtil.getJSONString(999);
        }
        boolean ret = followService.unFollow(envContext.getUser().getId(), CampusQaUtil.ENTITY_USER, userId);
        return CampusQaUtil.getJSONString(ret ? 0 : 1, String.valueOf(followService.getFolloweeCount(envContext.getUser().getId(), CampusQaUtil.ENTITY_USER)));
    }

    @ResponseBody
    @RequestMapping(path = {"/followQuestion"}, method = {RequestMethod.POST})
    public String followQuestion(@RequestParam("questionId") int questionId) {
        if (envContext.getUser() == null) {
            return CampusQaUtil.getJSONString(999);
        }

        Question question = questionService.getById(questionId);
        if (question == null) {
            return CampusQaUtil.getJSONString(1, "所关注的问题不存在");
        }

        boolean ret = followService.follow(envContext.getUser().getId(), CampusQaUtil.ENTITY_QUESTION, questionId);
        eventProducer.fireEvent(new EventModel(EventType.FOLLOW)
                .setActorId(envContext.getUser().getId())
                .setEntityId(questionId)
                .setEntityOwnerId(question.getUserId())
                .setExt("questionTitle", question.getTitle())
                .setEntityType(CampusQaUtil.ENTITY_QUESTION));
        Map<String, Object> info = new HashMap<>();
        info.put("headUrl", envContext.getUser().getHeadUrl());
        info.put("name", envContext.getUser().getName());
        info.put("id", envContext.getUser().getId());
        info.put("count", followService.getFollowerCount(CampusQaUtil.ENTITY_QUESTION, questionId));
        return CampusQaUtil.getJSONString(ret ? 0 : 1, info);
    }

    @RequestMapping(path = {"/unfollowQuestion"}, method = {RequestMethod.POST})
    @ResponseBody
    public String unfollowQuestion(@RequestParam("questionId") int questionId) {
        if (envContext.getUser() == null) {
            return CampusQaUtil.getJSONString(999);
        }

        Question question = questionService.getById(questionId);
        if (question == null) {
            return CampusQaUtil.getJSONString(1, "所关注的问题不存在");
        }

        boolean ret = followService.unFollow(envContext.getUser().getId(), CampusQaUtil.ENTITY_QUESTION, questionId);
        Map<String, Object> info = new HashMap<>();
        info.put("headUrl", envContext.getUser().getHeadUrl());
        info.put("name", envContext.getUser().getName());
        info.put("id", envContext.getUser().getId());
        info.put("count", followService.getFollowerCount(CampusQaUtil.ENTITY_QUESTION, questionId));
        return CampusQaUtil.getJSONString(ret ? 0 : 1, info);
    }

    @RequestMapping(path = {"/user/{userId}/followees"}, method = {RequestMethod.GET})
    public String followees(Model model, @PathVariable("userId") int userId) {
        List<Integer> followeesIds = followService.getFollewees(userId, CampusQaUtil.ENTITY_USER, 0, 10);
        if (envContext.getUser() != null) {
            model.addAttribute("followees", getUsersInfo(envContext.getUser().getId(), followeesIds));
        } else {
            model.addAttribute("followees", getUsersInfo(0, followeesIds));
        }
        model.addAttribute("followeeCount", followService.getFolloweeCount(userId, CampusQaUtil.ENTITY_USER));
        model.addAttribute("curUser", userService.getUser(userId));
        return "followees";
    }

    @RequestMapping(path = {"/user/{userId}/followers"}, method = {RequestMethod.GET})
    public String followers(Model model, @PathVariable("userId") int userId) {
        List<Integer> followersIds = followService.getFollowers(CampusQaUtil.ENTITY_USER, userId, 0, 10);
        if (envContext.getUser() != null) {
            model.addAttribute("followers", getUsersInfo(envContext.getUser().getId(), followersIds));
        } else {
            model.addAttribute("followers", getUsersInfo(0, followersIds));
        }
        model.addAttribute("followerCount", followService.getFollowerCount(CampusQaUtil.ENTITY_USER, userId));
        model.addAttribute("curUser", userService.getUser(userId));
        return "followers";
    }

    private List<ViewObject> getUsersInfo(int localUserId, List<Integer> userIds) {
        List<ViewObject> userInfos = new ArrayList<>();
        for (Integer userId : userIds) {
            User user = userService.getUser(userId);
            if (user == null) {
                continue;
            }
            ViewObject vo = new ViewObject();
            vo.set("user", user);
            vo.set("followerCount", followService.getFollowerCount(CampusQaUtil.ENTITY_USER, userId));
            vo.set("followeeCount", followService.getFolloweeCount(userId, CampusQaUtil.ENTITY_USER));
            vo.set("commentCount", commentService.getUserCommentCount(userId));
            if (localUserId != 0) {
                vo.set("followed", followService.isFollower(localUserId, CampusQaUtil.ENTITY_USER, userId));
            } else {
                vo.set("followed", false);
            }
            userInfos.add(vo);
        }
        return userInfos;
    }
}
