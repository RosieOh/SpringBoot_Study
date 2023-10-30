package com.chunjae.test04.persistance;

import com.chunjae.test04.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userMapper {

    // 사용자 정보 조회
    @Select("select * from user order by regdate desc")
    public List<User> userList();

    @Select("select * from user where id = #{id}")
    public User getUser(String id);

    @Insert("insert into userinfo values (#{id}, #{pw}, #{name}, #{email}, #{tel}, default, default, default, default")
    public User insertUser(User user);

    @Update("update user set pw=#{pw}, name=#{name}, email={email}, tel=#{tel}, default, default, default, default")
    public User updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public void deleteUser(String id);

    @Select("select count(*) from user")
    public int userCount();

    @Select("select * from user where id = #{id}")
    public User signIn(String id);

    @Select("select * from user where id = #{id}")
    public User loginCheck(User user);

    @Select("select * from user where id = #{id}")
    public User loginAjax(User user);

    @Select("select id from user where email=#{email}")
    public String findByEmail(String email);

    @Select("select pw from user where id=#{id}, and email=#{email}")
    public String findByPassword(String id, String email);

    @Select("select id, pw, name, from user where id = #{id")
    public User login(String id);
}
