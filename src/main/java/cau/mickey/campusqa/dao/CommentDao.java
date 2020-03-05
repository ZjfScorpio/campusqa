package cau.mickey.campusqa.dao;

import cau.mickey.campusqa.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author mickey
 * 操作数据库中comment表
 * mybatis api
 */
@Mapper
public interface CommentDao {
    String TABLE_NAME = " comment ";
    String INSERT_FIELDS = " user_id, content, created_date, entity_id, entity_type, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userId},#{content},#{createdDate},#{entityId},#{entityType},#{status})"})
    int addComment(Comment comment);

    @Select({"select ", SELECT_FIELDS, " from ",TABLE_NAME, " where id=#{id}"})
    Comment selectById(int id);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where entity_id=#{entityId} and entity_type=#{entityType} " +
            "order by created_date desc"})
    List<Comment> selectCommentByEntity(@Param("entityId") int entityId,
                                        @Param("entityType") int entityType);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where entity_id=#{entityId} and entity_type=#{entityType} " +
            " order by created_date desc limit #{offset}, #{limit}"})

    List<Comment> selectCommentByEntityWithLimit(@Param("entityId") int entityId,
                                        @Param("entityType") int entityType,
                                        @Param("offset") int offset,
                                        @Param("limit") int limit);

    @Select({"select count(id) from ", TABLE_NAME, " where entity_id=#{entityId} and entity_type=#{entityType}"})
    int getCommentCount(@Param("entityId") int entityId, @Param("entityType") int entityType);

    //更新状态
    @Update({"update comment set status=#{status} where id=#{id}"})
    int updateStatus(@Param("id") int id, @Param("status")int status);

    @Select({"select count(id) from ", TABLE_NAME, " where user_id=#{userId}"})
    int getUserCommentCount(int userId);

    //删除评论
    @Delete({"delete from",TABLE_NAME,"where id=#{id}"})
    int delQuestion(int id);

    //通过用户id查评论
    @Select({"select ",SELECT_FIELDS," from ", TABLE_NAME, " where user_id=#{userId}"})
    List<Comment> getCommentsByUserId(int userId);


}
