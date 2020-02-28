package cau.mickey.campusqa.dao;

import cau.mickey.campusqa.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * @author mickey
 * 操作数据库中question表
 * mybatis api
 */
@Mapper
public interface QuestionDao {
    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title, content, created_date, user_id, comment_count ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{title},#{content},#{createdDate},#{userId},#{commentCount})"})
    int addQuestion(Question question);

    @Select({"select ", SELECT_FIELDS, " from ",TABLE_NAME, " where id=#{id}"})
    Question selectById(int id);

    @Update({"update ",TABLE_NAME, " set comment_count=#{commentCount} where id=#{id}"})
    void updateCommentCount(@Param("commentCount")int commentCount, @Param("id") int id);

    List<Question> selectLatestQuestions(@Param("userId") int userId, @Param("offset") int offset,
                                         @Param("limit") int limit);
    //删除问题
    @Delete({"delete from",TABLE_NAME,"where id=#{id}"})
    int delQuestion(int id);

}
