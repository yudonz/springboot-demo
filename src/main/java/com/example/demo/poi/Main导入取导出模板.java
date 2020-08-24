package com.example.demo.poi;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/13 13:54
 * @description：程序入口
 */
public class Main导入取导出模板 {
    private static Logger logger = Logger.getLogger(Main导入取导出模板.class.getName());

    private static final String inputPath = "D:/project/市场司/市场司/材料初审.xls";
    private static final String outputPath = "C:\\Users\\Administrator\\Desktop\\不同之处22.xls";

    public static void main(String[] args) {

        // 设定Excel文件所在路径
        String excelFileName1 = inputPath;
        // 读取Excel文件内容
        List<ExcelData> readResult1 = ExcelReader.readExcel(excelFileName1);
        //do some operations...


        List<ExcelData> outData = new ArrayList<>();
        //do some operations...
        ExcelWriter.writeExcel(outData, outputPath);


    }
}
