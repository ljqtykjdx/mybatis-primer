package com.imooc.mybatis.pattern;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection", "Duplicates"})
public class StartNoXml {
    public static void main(String[] args) throws SQLException {
        // 无需xml配置的方式使用MyBatis
        // 准备jdbc事务类
        JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
        // 配置数据源
        PooledDataSource dataSource =
                new PooledDataSource("com.mysql.cj.jdbc.Driver",
                        "jdbc:mysql://localhost:3306/imooc?useSSL=false&serverTimezone=GMT%2B8",
                        "root", "000628");
        // 配置环境，向环境中指定环境id、事务和数据源
        Environment environment = new Environment.Builder("development")
                .transactionFactory(jdbcTransactionFactory)
                .dataSource(dataSource).build();
        // 新建 MyBatis 配置类
        Configuration configuration = new Configuration(environment);
        // 得到 SqlSessionFactory 核心类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // 开始一个 sql 会话
        SqlSession session = sqlSessionFactory.openSession();
        // 得到 sql 连接并运行 sql 语句
        PreparedStatement preStatement = session
                .getConnection()
                .prepareStatement("SELECT * FROM imooc_user WHERE id = ?");
        preStatement.setInt(1, 1);
        ResultSet result = preStatement.executeQuery();
        // 验证结果
        while (result.next()) {
            System.out.println("username: " + result.getString("username"));
        }


        // 关闭会话
        session.close();
    }
}
