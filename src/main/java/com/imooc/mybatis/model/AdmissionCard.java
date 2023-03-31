package com.imooc.mybatis.model;

import lombok.Data;

/**
 * @since 2023/3/3
 */
@Data
public class AdmissionCard {

    /**
     * 序号
     */
    private String number;
    /**
     * 姓名
     */
    private String name;
    /**
     * 科室名称
     */
    private String offices;
    /**
     * 职务
     */
    private String post;
    /**
     * 主管业务
     */
    private String business;
    /**
     * 办公电话
     */
    private String bgphone;
    /**
     * 移动电话
     */
    private String ydphone;
    /**
     * 工作邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String image;
}
