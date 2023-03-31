package com.imooc.mybatis.mapper;

import com.imooc.mybatis.model.User;
import com.imooc.mybatis.model.UserShortCut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT username FROM imooc_user WHERE id = #{id}")
    String selectUsernameById(Integer id);

    Integer selectUserAgeById(Integer id);

    User selectUserByAgeAndScore(User user);


    UserShortCut selectUserShortcutById(Integer id);

    int insertUser(User user);

    int updateUserAgeById(@Param("age") Integer age, @Param("id") Integer id);

    User selectUserByNameCondition(User user);

    User selectUserByIdOrName(@Param("id") Integer id, @Param("username") String username);

    User selectUsernameLowercase(String username);

    int insertUserDynamic(User user);

    List<User> selectUserInNames(@Param("names") List<String> names);

    int insertUsers(@Param("users") List<User> users);

    User selectUserById(Integer i);
}
