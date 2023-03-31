//package com.imooc.mybatis.util;
//
//import org.apache.poi.hssf.usermodel.*;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//
//public class PicDcUtils {
//
//
//    private HSSFWorkbook createImage(String content, String title,HSSFWorkbook wb) {
//
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
//        if (wb == null) {
//            wb = new HSSFWorkbook();
//        }
//
//
//
//
//
//
//
//        BufferedImage bufferImg = null;//图片一
//        try {
//            //创建
//            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
//            //将内容按顺序赋给对应的列对象
//            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
//            //将两张图片读到BufferedImage
//            String idPath = list.get(i).getPath();
//            //图片路径
//            String imagePath = "F:/Desktop" + idPath;
//            if (new File(imagePath).exists()) {
//                bufferImg = ImageIO.read(new File(imagePath));
//                ImageIO.write(bufferImg, "png", byteArrayOut);
//                //图片一导出到单元格E2中
//                HSSFClientAnchor anchor = new HSSFClientAnchor(480, 30, 700, 250,
//                        (short) 4, i + 1, (short) 4, i + 1);
//                // 插入图片,注意这个问题PICTURE_TYPE_JPEG。如果导出的图片没有显示出来，改动这里
//                patriarch.createPicture(anchor, wb.addPicture(byteArrayOut
//                        .toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
//            }
//
//
//        } catch (Exception e) {
//
//        }
//
//        return wb;
//    }
//
//
//
//
//
//
//}
