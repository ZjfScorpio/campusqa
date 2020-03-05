package cau.mickey.campusqa.dao;

import cau.mickey.campusqa.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author mickey
 * 操作数据库中user表
 * mybatis api
 */
@Mapper
public interface UserDao {
    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " name, password, salt, head_url, email ,status";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, " ( ", INSERT_FIELDS,
            ") values (#{name}, #{password}, #{salt}, #{headUrl}, #{email},0)"})
    int addUser(User user);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME})
    List<User> selectUsers();

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id} "})
    User selectById(int id);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where name=#{name} "})
    User selectByName(String name);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where email=#{email} "})
    User selectByEmail(String email);

    @Update({"update ", TABLE_NAME, " set password=#{password} where id=#{id}"})
    void updatePassword(User user);

    @Update({"update ", TABLE_NAME, " set status=#{status} where id=#{id}"})
    void updateStatus(User user);

    @Delete({"delete from ", TABLE_NAME, " where id=#{id}"})
    void deleteById(int id);
}
