package cau.mickey.campusqa.controller;

import cau.mickey.campusqa.async.EventModel;
import cau.mickey.campusqa.async.EventProducer;
import cau.mickey.campusqa.async.EventType;
import cau.mickey.campusqa.model.Comment;
import cau.mickey.campusqa.util.EnvContext;
import cau.mickey.campusqa.service.CommentService;
import cau.mickey.campusqa.service.LikeService;
import cau.mickey.campusqa.util.CampusQaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mickey
 * 接口
 * 点赞
 */
@Controller
public class LikeController {
    @Autowired
    private LikeService likeService;

    @Autowired
    private EnvContext envContext;

    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = {"/like"}, method = {RequestMethod.POST})
    @ResponseBody
    public String like(@RequestParam("commentId") int commentId) {
        if (envContext.getUser() == null) {
            return CampusQaUtil.getJSONString(999);
        }
        long likeCount = likeService.like(envContext.getUser().getId(), CampusQaUtil.ENTITY_COMMENT, commentId);

        Comment comment = commentService.getCommentById(commentId);

        eventProducer.fireEvent(new EventModel(EventType.LIKE)
                .setActorId(envContext.getUser().getId())
                .setEntityType(CampusQaUtil.ENTITY_COMMENT)
                .setEntityId(commentId)
                .setEntityOwnerId(comment.getUserId())
                .setExt("questionId",String.valueOf(comment.getEntityId()))
        );

        return CampusQaUtil.getJSONString(0, String.valueOf(likeCount) + "赞同");
    }

    @RequestMapping(path = {"/dislike"}, method = {RequestMethod.POST})
    @ResponseBody
    public String disLike(@RequestParam("commentId") int commentId) {
        if (envContext.getUser() == null) {
            return CampusQaUtil.getJSONString(999);
        }
        long likeCount = likeService.disLike(envContext.getUser().getId(), CampusQaUtil.ENTITY_COMMENT, commentId);
        return CampusQaUtil.getJSONString(0, String.valueOf(likeCount) + "赞同");
    }

}
