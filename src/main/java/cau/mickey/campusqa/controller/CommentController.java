package cau.mickey.campusqa.controller;

import cau.mickey.campusqa.async.EventProducer;
import cau.mickey.campusqa.model.Comment;
import cau.mickey.campusqa.util.EnvContext;
import cau.mickey.campusqa.service.CommentService;
import cau.mickey.campusqa.service.QuestionService;
import cau.mickey.campusqa.util.CampusQaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
/**
 * @author mickey
 * 接口
 * 回答
 */
@Controller
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;

    @Autowired
    private EnvContext envContext;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private EventProducer eventProducer;

    @RequestMapping(path = {"/addComment"}, method = {RequestMethod.POST})
    public String addComment(@RequestParam("questionId") int questionId,
                             @RequestParam("content") String content) {
        try {
            Comment comment = new Comment();
            comment.setContent(content);
            if (envContext.getUser() != null) {
                comment.setUserId(envContext.getUser().getId());
            } else {
                return "redirect:/loginReg";
            }
            comment.setCreatedDate(new Date());
            comment.setEntityId(questionId);
            comment.setEntityType(CampusQaUtil.ENTITY_QUESTION);
            commentService.addComment(comment);
            //更新问题评论数
            int count = commentService.getCommentCount(comment.getEntityId(), comment.getEntityType());
            questionService.updateCommentCount(count, comment.getEntityId());
/*            eventProducer.fireEvent(new EventModel(EventType.COMMENT)
                    .setExt("username",envContext.getUser().getName())
                    .setEntityId(questionId)
                    .setExt("email", "guom_zh@qq.com")
            );*/

        } catch (Exception e) {
            logger.error("增加评论失败" + e.getMessage());
        }
        return "redirect:/question/" + questionId;
    }

    @RequestMapping(value = "/comment/del", method = {RequestMethod.POST})
    @ResponseBody
    public String delComment(@RequestParam("id")  int id) {
        try {
            if (envContext.getUser() == null) {
                return CampusQaUtil.getJSONString(999);
            } else {
                Comment comment = commentService.getCommentById(id);
                int ownerId = comment.getUserId();
                //如果当前用户是回答人可以删除
                if(envContext.getUser().getId() == ownerId)
                    if(commentService.delCommentById(id)>0)
                        return CampusQaUtil.getJSONString(0);
            }

        } catch (Exception e) {
            logger.error("删除评论失败" + e.getMessage());
        }
        return CampusQaUtil.getJSONString(1, "失败");
    }
}
