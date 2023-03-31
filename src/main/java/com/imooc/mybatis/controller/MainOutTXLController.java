//package com.imooc.mybatis.controller;
//
//
//
//import com.imooc.mybatis.service.cwxxtxlService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
//public class MainOutTXLController {
//    @Autowired
//    private cwxxtxlService cwxxtxlService;
//
//    //@UserOperate(moduleName = "通讯录管理模块",operate = "根据单位id获取通讯录信息")
//    @RequestMapping(value = "/txl/dcTxlMsg/{dwId}",method = RequestMethod.GET)
//    public Object  gettxlById(@PathVariable("dwId")  String dwId){
//        Object ret = null;
//
//        try{
//            ret =  cwxxtxlService.dcTxlMsg(dwId);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//            return ret;
//        }
//
//}
