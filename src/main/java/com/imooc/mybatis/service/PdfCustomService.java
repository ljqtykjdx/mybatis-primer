package com.imooc.mybatis.service;

import com.imooc.mybatis.model.AdmissionCard;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * @since 2021/7/11 16:12
 */
public interface PdfCustomService {

    /**
     * 通讯录PDF
     * @param admissionCard 准考证信息
     * @param response 响应
     */
    void generatorAdmissionCard(AdmissionCard admissionCard, HttpServletResponse response) throws UnsupportedEncodingException, FileNotFoundException;
}

