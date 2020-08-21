package com.example.demo.poi;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/13 17:26
 * @description：写入Excel
 */
public class ExcelWriter {
    private static List<String> CELL_HEADS; //列头

    private static Logger logger = Logger.getLogger(ExcelWriter.class.getName());//日志打印类

    static {
        // 类装载时就载入指定好的列头信息，如有需要，可以考虑做成动态生成的列头
        CELL_HEADS = new ArrayList<>();
        CELL_HEADS.add("序号/id");
        CELL_HEADS.add("状态");
        CELL_HEADS.add("主体名称");
        CELL_HEADS.add("主体类型");
        CELL_HEADS.add("等级");
        CELL_HEADS.add("联系人");
        CELL_HEADS.add("建设内容及规模");
        CELL_HEADS.add("总投资金额(万元)");
        CELL_HEADS.add("申请补贴金额");
        CELL_HEADS.add("预计补贴金额");
        CELL_HEADS.add("拟补贴金额");
        CELL_HEADS.add("实际补贴金额");
        CELL_HEADS.add("省");
        CELL_HEADS.add("市");
        CELL_HEADS.add("区");
        CELL_HEADS.add("是否贫困县");
        CELL_HEADS.add("是否建立在田头市场");
        CELL_HEADS.add("仓储产品");
        CELL_HEADS.add("项目创建时间");
        CELL_HEADS.add("项目审核时间");
        CELL_HEADS.add("主体认证状态");
    }

    /**
     * 导出excel
     */
    public static void writeExcel(List<ExcelData> dataList, String fileName) {
        // 获取Excel后缀名
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        // 导入数据，以文件的形式输出工作簿对象
        Workbook workbook = exportData(dataList, fileType);
        // 导出为文件
        FileOutputStream fileOut = null;
        try {
            String exportFilePath = fileName;
            File exportFile = new File(exportFilePath);
            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }
            fileOut = new FileOutputStream(exportFilePath);
            workbook.write(fileOut);
            fileOut.flush();
        } catch (Exception e) {
            logger.warning("输出Excel时发生错误，错误原因：" + e.getMessage());
        } finally {
            try {
                if (null != fileOut) {
                    fileOut.close();
                }
                if (null != workbook) {
                    workbook.close();
                }
            } catch (IOException e) {
                logger.warning("关闭输出流时发生错误，错误原因：" + e.getMessage());
            }
        }
    }


    /**
     * 生成Excel并写入数据信息
     *
     * @param dataList 数据列表
     * @return 写入数据后的工作簿对象
     */
    public static Workbook exportData(List<ExcelData> dataList, String fileType) {
        Workbook workbook = null;
        if (fileType.equals("xlsx")) {
            // 生成xlsx的Excel
            workbook = new SXSSFWorkbook();
        } else if (fileType.equals("xls")) {
            // 如需生成xls的Excel，请使用下面的工作簿对象，注意后续输出时文件后缀名也需更改为xls
            workbook = new HSSFWorkbook();
        }

        // 生成Sheet表，写入第一行的列头
        Sheet sheet = buildDataSheet(workbook);
        //构建每行的数据内容
        int rowNum = 1;
        for (Iterator<ExcelData> it = dataList.iterator(); it.hasNext(); ) {
            ExcelData data = it.next();
            if (data == null) {
                continue;
            }
            //输出行数据
            Row row = sheet.createRow(rowNum++);
            convertDataToRow(data, row);
        }
        return workbook;
    }

    /**
     * 生成sheet表，并写入第一行数据（列头）
     *
     * @param workbook 工作簿对象
     * @return 已经写入列头的Sheet
     */
    private static Sheet buildDataSheet(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        // 设置列头宽度
        for (int i = 0; i < CELL_HEADS.size(); i++) {
            sheet.setColumnWidth(i, 4000);
        }
        // 设置默认行高
        sheet.setDefaultRowHeight((short) 400);
        // 构建头单元格样式
        CellStyle cellStyle = buildHeadCellStyle(sheet.getWorkbook());
        // 写入第一行各列的数据
        Row head = sheet.createRow(0);
        for (int i = 0; i < CELL_HEADS.size(); i++) {
            Cell cell = head.createCell(i);
            cell.setCellValue(CELL_HEADS.get(i));
            cell.setCellStyle(cellStyle);
        }
        return sheet;
    }

    /**
     * 设置第一行列头的样式
     *
     * @param workbook 工作簿对象
     * @return 单元格样式对象
     */
    private static CellStyle buildHeadCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        //对齐方式设置
        style.setAlignment(HorizontalAlignment.CENTER);
        //边框颜色和宽度设置
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex()); // 下边框
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex()); // 左边框
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex()); // 右边框
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex()); // 上边框
        //设置背景颜色
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //粗体字设置
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    /**
     * 将数据转换成行
     *
     * @param data 源数据
     * @param row  行对象
     * @return
     */
    private static void convertDataToRow(ExcelData data, Row row) {
        int cellNum = 0;
        Cell cell;

        // 第一列
        cell = row.createCell(0);
        cell.setCellValue(null == data.getId() ? "" : data.getId().toString());

        // 第二列 状态
        cell = row.createCell(1);
        if (null != data.getStatus()) {
            cell.setCellValue(data.getStatus());
        } else {
            cell.setCellValue("");
        }

        // 第三列 主体名称
        cell = row.createCell(2);
        cell.setCellValue(null == data.getName() ? "" : data.getName());

        // 第四列 主体类型
        cell = row.createCell(3);
        cell.setCellValue(null == data.getType() ? "" : data.getType());

        // 第五列 等级
        cell = row.createCell(4);
        cell.setCellValue(null == data.getLevel() ? "" : data.getLevel());

        // 第六列 联系人
        cell = row.createCell(5);
        cell.setCellValue(null == data.getPhone() ? "" : data.getPhone().toString());

        // 第七列 建设内容及规模
        cell = row.createCell(6);
        cell.setCellValue(null == data.getContent() ? "" : data.getContent());

        // 第八列 总投资金额
        cell = row.createCell(7);
        cell.setCellValue(null == data.getInvest() ? "" : data.getInvest().toString());

        // 第九列 申请补贴金额
        cell = row.createCell(8);
        cell.setCellValue(null == data.getApply() ? "" : data.getApply().toString());

        // 第十列 预计补贴金额
        cell = row.createCell(9);
        cell.setCellValue(null == data.getEstimate() ? "" : data.getEstimate().toString());

        // 第十一列 拟补贴金额
        cell = row.createCell(10);
        cell.setCellValue(null == data.getProposed() ? "" : data.getProposed().toString());

        // 第十二列 实际补贴金额
        cell = row.createCell(11);
        cell.setCellValue(null == data.getActual() ? "" : data.getActual().toString());

        // 第十三列 省
        cell = row.createCell(12);
        cell.setCellValue(null == data.getProvince() ? "" : data.getProvince());

        // 第十四列 市
        cell = row.createCell(13);
        cell.setCellValue(null == data.getCity() ? "" : data.getCity());

        // 第十五列 区
        cell = row.createCell(14);
        cell.setCellValue(null == data.getDistrict() ? "" : data.getDistrict());

        // 第十六列 是否贫困
        cell = row.createCell(15);
        cell.setCellValue(null == data.getIsPoor() ? "" : data.getIsPoor());

        // 第十七列 是否建立
        cell = row.createCell(16);
        cell.setCellValue(null == data.getIsFarm() ? "" : data.getIsFarm());

        // 第十八列 仓储产品
        cell = row.createCell(17);
        cell.setCellValue(null == data.getProducts() ? "" : data.getProducts().toString());

        // 第十九列 创建时间
        cell = row.createCell(18);
        cell.setCellValue(null == data.getCreate() ? "" : data.getCreate().toString());
        // 第二十列 更新时间
        cell = row.createCell(19);
        cell.setCellValue(null == data.getUpdate() ? "" : data.getUpdate().toString());
        // 第二十一列
        cell = row.createCell(20);
        cell.setCellValue(null == data.getStatus2() ? "" : data.getStatus2().toString());

    }

}
