package com.imooc.mybatis.controller;


import com.imooc.mybatis.util.QrCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;


@RestController
@Api(value = "二维码相关操作接口", tags = "二维码相关操作接口")
@RequestMapping("/QrCode")
public class QrCodeController {
    @ApiOperation(value = "导出二维码")
    @GetMapping ("/ll/{content}/{title}")
    public BufferedImage generatorAdmissionCard(@PathVariable("content") String content, @PathVariable("title") String title ){
        BufferedImage bufferedImage = new BufferedImage(0,0,0);
        try {
            QrCodeUtils qrCodeUtils = new QrCodeUtils();
            bufferedImage = qrCodeUtils.buildQrCodeImage(content, title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }


}
