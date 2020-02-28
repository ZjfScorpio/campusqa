package cau.mickey.campusqa.async;

import java.util.List;

/**
 * @author mickey
 * 事件处理器接口
 */
public interface EventHandler {

    void doHandle(EventModel model);

    List<EventType> getSupportEventTypes();
}
