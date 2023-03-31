package com.imooc.mybatis.pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection", "Duplicates"})
public class StartWithXml {

    public static void main(String[] args) throws IOException, SQLException {
        // 配置式使用MyBatis
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 按照配置文件得到 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 新建会话
        SqlSession session = sqlSessionFactory.openSession();
        // 执行SQL
        PreparedStatement preStatement = session.getConnection().prepareStatement("SELECT * FROM imooc_user WHERE id = ?");
        preStatement.setInt(1, 1);
        ResultSet result = preStatement.executeQuery();
        while (result.next()) {
            System.out.println("username: " + result.getString("username"));
        }
        // 关闭会话
        session.close();
    }
}
