package cau.mickey.campusqa.async.handler;

import cau.mickey.campusqa.service.SearchService;
import cau.mickey.campusqa.async.EventHandler;
import cau.mickey.campusqa.async.EventModel;
import cau.mickey.campusqa.async.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author mickey
 * 添加问题时更新solr数据库的事件
 */
@Component
public class AddQuestionHandler  implements EventHandler {
    private static final Logger logger = LoggerFactory.getLogger(AddQuestionHandler.class);
    @Autowired
    private SearchService searchService;

    @Override
    public void doHandle(EventModel model) {
        try {
            boolean ret = searchService.indexQuestion(model.getEntityId(),model.getExt("title"),model.getExt("content"));
            if(!ret){
                logger.error("建立问题索引失败");
            }
        } catch (Exception e){
            logger.error("建立问题索引失败"+e.getMessage());
        }
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.ADD_QUESTION);
    }
}
