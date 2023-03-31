package com.imooc.mybatis.pattern;

import com.imooc.mybatis.mapper.UserMapper;
import com.imooc.mybatis.model.User;
import com.imooc.mybatis.model.UserShortCut;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"Duplicates"})
public class StartWithMapper {
    public static void main(String[] args) throws IOException, SQLException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        // 得到 mapper
//        UserMapper mapper = session.getMapper(UserMapper.class);
        // 调用注解的SQL
//        String username = mapper.selectUsernameById(1);
//        System.out.println("username: " + username);
        // 调用XML的SQL
//        Integer age = mapper.selectUserAgeById(1);
//        System.out.println("age: " + age);
        // 得到 mapper
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//
//        int rows = userMapper.updateUserAgeById(180, 1);
//        System.out.println(rows);

//        User condition = new User();
//        condition.setAge(18);
//        condition.setScore(100);
//        // 调用方法
//        User user = userMapper.selectUserByAgeAndScore(condition);
//        // 得到 user
//        System.out.println(user.getUsername());
//
//
////
//        UserShortCut shortCut = userMapper.selectUserShortcutById(1);
//        System.out.println(shortCut.getUsername());

//        User users = new User();
//        users.setUsername("insert test");
//        users.setAge(100);
//        users.setScore(100000);
//        int rows = userMapper.insertUser(users);
//        System.out.println(rows);

//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        User pedro = userMapper.selectUserByIdOrName(null, null);
//        System.out.println(pedro);

//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        User pedro = userMapper.selectUsernameLowercase("PEDRO");
//        System.out.println(pedro);



//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        User user = new User();
//        user.setUsername("dynamic");
//        user.setScore(100);
//        int rows = userMapper.insertUserDynamic(user);
//        System.out.println(rows);

//        UserMapper userMapper = session.getMapper(UserMapper.class);
////        List<User> users = userMapper.selectUserInNames(Arrays.asList("pedro", "peter"));
////        System.out.println(users);
//
//        User user1 = new User();
//        user1.setUsername("user1");
//        user1.setScore(100);
//        user1.setAge(0);
//        User user2 = new User();
//        user2.setUsername("user2");
//        user2.setScore(210);
//        user2.setAge(20);
//        int rows = userMapper.insertUsers(Arrays.asList(user1, user2));
//        System.out.println(rows);

        SqlSession session1 = sqlSessionFactory.openSession();
        UserMapper userMapper1 = session1.getMapper(UserMapper.class);
        User user1 = userMapper1.selectUserById(1);
        System.out.println(user1);
        SqlSession session2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = session2.getMapper(UserMapper.class);
        User user2 = userMapper2.selectUserById(1);
        System.out.println(user2);




//        // 一定要提交
        session.commit();







        // 关闭会话
        session.close();
    }
}
