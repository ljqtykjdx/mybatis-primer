//package com.imooc.mybatis.controller;
//
//import io.swagger.annotations.ApiOperation;
//import org.apache.poi.hssf.usermodel.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.OutputStream;
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//
//public class exportExcelController {
//
//    @GetMapping("/exportRemoteDetectionResult")
//    @ResponseBody
//    @ApiOperation(value = "导出切片结果到excel", httpMethod = "GET")
//    public void exportExcelPic(@RequestParam List<String> idList, HttpServletResponse response) {
//        //根据id获取所有要导出的数据
//        List<RemoteDetectionResult> list = remoteDetectionResultService.getByIdList(idList);
//        //导出的标题
//        String[] title = {"目标名称", "目标类别", "置信度", "目标位置", "目标切片", "目标检测时间", "所属影像", "影像拍摄时间", "影像来源"};
//        //excel名称
//        String fileName = "切片报告.xls";
//        //sheet名称
//        String sheetName = "切片信息";
//        //调用导出方法
//        HSSFWorkbook wb = getHSSFWorkbook(sheetName, title, list, null);
//
//        try {
//            this.setResponseHeader(response, fileName);
//            OutputStream os = response.getOutputStream();
//            wb.write(os);
//            os.flush();
//            os.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println(e.getMessage());
//        }
//    }
//
//
//    //导出切片excel的方法
//    public HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, List<RemoteDetectionResult> list, HSSFWorkbook wb) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
//        if (wb == null) {
//            wb = new HSSFWorkbook();
//        }
//
//        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
//        HSSFSheet sheet = wb.createSheet(sheetName);
//
//        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
//        HSSFRow row = sheet.createRow(0);
//        row.setHeight((short) 650);
//        // 第四步，创建单元格，并设置表头值 设置表头居中
//        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//        //声明列对象
//        HSSFCell cell = null;
//
//        //创建标题
//        for (int i = 0; i < title.length; i++) {
//            sheet.setColumnWidth(i, 6000);
//            cell = row.createCell(i);
//            cell.setCellValue(title[i]);
//            HSSFFont font = wb.createFont();
//            font.setFontName("黑体");
//            font.setFontHeightInPoints((short) 15);//设置字体大小
//            style.setFont(font);
//            cell.setCellStyle(style);
//        }
//        BufferedImage bufferImg = null;//图片一
//        try {
//            //创建内容
//            HSSFCellStyle styleCon = wb.createCellStyle();
//            styleCon.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
//            styleCon.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
//            for (int i = 0; i < list.size(); i++) {
//                row = sheet.createRow(i + 1);
//                row.setHeight((short) 550);
//                RemoteDetectionResult keeSpecimen = list.get(i);
//                //将内容按顺序赋给对应的列对象
//                HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
//                //将两张图片读到BufferedImage
//                String idPath = list.get(i).getPath();
//                //图片路径
//                String imagePath = "F:/Desktop" + idPath;
//                if (new File(imagePath).exists()) {
//                    bufferImg = ImageIO.read(new File(imagePath));
//                    ImageIO.write(bufferImg, "png", byteArrayOut);
//                    //图片一导出到单元格E2中
//                    HSSFClientAnchor anchor = new HSSFClientAnchor(480, 30, 700, 250,
//                            (short) 4, i + 1, (short) 4, i + 1);
//                    // 插入图片,注意这个问题PICTURE_TYPE_JPEG。如果导出的图片没有显示出来，改动这里
//                    patriarch.createPicture(anchor, wb.addPicture(byteArrayOut
//                            .toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
//                }
//                //按列添加数据，第一列为0，依次类推
//                cell = row.createCell(0);
//                cell.setCellValue(keeSpecimen.getLabel3());
//                cell.setCellStyle(styleCon);
//                cell = row.createCell(1);
//                cell.setCellValue(keeSpecimen.getLabel2());
//                cell.setCellStyle(styleCon);
//                cell = row.createCell(2);
//                cell.setCellValue(keeSpecimen.getScore());
//                cell.setCellStyle(styleCon);
//                cell = row.createCell(3);
//                cell.setCellValue(keeSpecimen.getGbbox());
//                cell.setCellStyle(styleCon);
//                cell = row.createCell(5);
//                cell.setCellValue(keeSpecimen.getCreatetime());
//                cell.setCellStyle(styleCon);
//                cell = row.createCell(6);
//                cell.setCellValue(keeSpecimen.getImagename());
//                cell.setCellStyle(styleCon);
//                cell = row.createCell(7);
//                cell.setCellValue(keeSpecimen.getImagetime());
//                cell.setCellStyle(styleCon);
//                cell = row.createCell(8);
//                cell.setCellValue(keeSpecimen.getImageequipment());
//                cell.setCellStyle(styleCon);
//            }
//            return wb;
//        } catch (Exception e) {
//            // TODO: handle exception
//            System.err.println(e.getMessage());
//        }
//        return wb;
//    }
//
//
//    //发送响应流方法
//    public void setResponseHeader(HttpServletResponse response, String fileName) {
//        try {
//            try {
//                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            response.setContentType("application/octet-stream;charset=ISO8859-1");
//            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//            response.addHeader("Pargam", "no-cache");
//            response.addHeader("Cache-Control", "no-cache");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//}