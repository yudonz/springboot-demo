package com.example.demo.poi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/14 11:38
 * @description：
 */
public class Main三表 {
    private static final String inputPath1 = "D:/project/申报项目1.xls";
    private static final String inputPath2 = "D:/project/新农直报0814.xlsx";
    private static final String outputPath = "C:\\Users\\Administrator\\Desktop\\有差异的.xlsx";
    private static final String outputPath1 = "C:\\Users\\Administrator\\Desktop\\对面有的.xlsx";
    private static final String outputPath2 = "C:\\Users\\Administrator\\Desktop\\我们有的.xlsx";

    public static void main(String[] args) {
        List<ExcelData> readResult1 = ExcelReader.readExcel(inputPath1);
        List<ExcelData> readResult2 = ExcelReader2.readExcel(inputPath2);

        different(readResult1, readResult2);
        theirs(readResult1, readResult2);
        ours(readResult1, readResult2);
    }

    public static void different(List<ExcelData> readResult1, List<ExcelData> readResult2) {
        Map<Long, ExcelData> collect = readResult2.stream()
                .collect(Collectors.toMap(ExcelData::getPhone, Function.identity(), (key1, key2) -> key2));
        List<ExcelData> outData = new ArrayList<>();

        for (ExcelData excelData : readResult1) {
            //两边都有的数据
            if (collect.containsKey(excelData.getPhone())) {
                if (!excelData.getStatus().equals(collect.get(excelData.getPhone()).getStatus())) {
                    outData.add(excelData);
                    outData.add(collect.get(excelData.getPhone()));
                }
            }
        }
        ExcelWriter.writeExcel(outData, outputPath);

    }

    public static void theirs(List<ExcelData> readResult1, List<ExcelData> readResult2) {
        Map<Long, ExcelData> collect = readResult2.stream()
                .collect(Collectors.toMap(ExcelData::getPhone, Function.identity(), (key1, key2) -> key2));
        List<ExcelData> outData = new ArrayList<>();

        for (ExcelData excelData : readResult1) {
            //对面有我们没的
            if (!collect.containsKey(excelData.getPhone())) {
                System.out.println("他有" + excelData);
                outData.add(excelData);
            }
        }
        ExcelWriter.writeExcel(outData, outputPath1);
    }

    public static void ours(List<ExcelData> readResult1, List<ExcelData> readResult2) {
        Map<Long, ExcelData> collect = readResult1.stream()
                .collect(Collectors.toMap(ExcelData::getPhone, Function.identity(), (key1, key2) -> key2));
        List<ExcelData> outData = new ArrayList<>();

        for (ExcelData excelData : readResult2) {
            //我们有对面没的
            if (!collect.containsKey(excelData.getPhone())) {
                System.out.println("我有" + excelData);
                outData.add(excelData);
            }
        }
        ExcelWriter.writeExcel(outData, outputPath2);
    }
}
