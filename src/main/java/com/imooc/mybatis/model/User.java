package com.imooc.mybatis.model;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String username;
    private Integer age;
    private Integer score;
    // 省略了 getter 和 setter 方法，请务必通过 IDE 生成，否则 MyBatis 无法自动映射


    public User() {
    }
    public User(Long id, String username, Integer age, Integer score) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
