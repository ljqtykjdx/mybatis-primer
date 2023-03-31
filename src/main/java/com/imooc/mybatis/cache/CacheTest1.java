package com.imooc.mybatis.cache;

import com.imooc.mybatis.mapper.UserMapper;
import com.imooc.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings({"Duplicates"})
public class CacheTest1 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        // 得到 mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 查询得到 user1
        User user1 = userMapper.selectUsernameLowercase("user1");
        System.out.println(user1);
        // 查询得到 user2
        User user2 = userMapper.selectUsernameLowercase("user1");
        // 通过 == 判断 user1 和 user2 是否指向同一内存区间
        System.out.println(user1 == user2);
        session.commit();
        session.close();
    }
}
