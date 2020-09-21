package com.example.demo.poi;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/13 13:55
 * @description：读取市场司的内容
 */
public class ExcelReader {
    private static Logger logger = Logger.getLogger(ExcelReader.class.getName()); // 日志打印类

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 读取Excel文件内容
     *
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public static List<ExcelData> readExcel(String fileName) {

        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 获取Excel文件
            File excelFile = new File(fileName);
            if (!excelFile.exists()) {
                logger.warning("指定的Excel文件不存在！");
                return null;
            }

            // 获取Excel工作簿
            inputStream = new FileInputStream(excelFile);
            workbook = getWorkbook(inputStream, fileType);

            // 读取excel中的数据
            List<ExcelData> resultDataList = parseExcel(workbook);

            return resultDataList;
        } catch (Exception e) {
            logger.warning("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.warning("关闭数据流出错！错误信息：" + e.getMessage());
                return null;
            }
        }
    }

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     *
     * @param inputStream 读取文件的输入流
     * @param fileType    文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }


    /**
     * 解析Excel数据
     *
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List<ExcelData> parseExcel(Workbook workbook) {
        List<ExcelData> resultDataList = new ArrayList<>();
        // 解析sheet
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();//获取实际第一行：标题 的下标
            Row firstRow = sheet.getRow(firstRowNum);//获取实际第一行
            if (null == firstRow) {
                logger.warning("解析Excel失败，在第一行没有读取到任何数据！");
            }

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 2; //实际数据从标题往下第几行，要改
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);

                if (null == row) {
                    continue;
                }

                ExcelData resultData = convertRowToData(row);
                if (null == resultData) {
                    logger.warning("第 " + row.getRowNum() + "行数据不合法，已忽略！");
                    continue;
                }
                resultDataList.add(resultData);
            }
        }

        return resultDataList;
    }


    /**
     * 提取每一行中需要的数据，构造成为一个结果数据对象
     * <p>
     * 当该行中有单元格的数据为空或不合法时，忽略该行的数据
     *
     * @param row 行数据
     * @return 解析后的行数据对象，行数据错误时返回null
     */
    private static ExcelData convertRowToData(Row row) {
        ExcelData resultData = new ExcelData();

        Cell cell;
        int cellNum = 0;

        try {
            // 第一列序号
            cell = row.getCell(0);
            String A = convertCellValueToString(cell);
            if (!StringUtils.isBlank(A)) {
                if (!A.equals("-")) {
                    resultData.setId(Integer.valueOf(A));
                }
            }

            // 第二列状态
            cell = row.getCell(1);
            String B = convertCellValueToString(cell);
            resultData.setStatus(B);

            // 第三列主体名称
            cell = row.getCell(2);
            String C = convertCellValueToString(cell);
            resultData.setName(C);

            // 第四列主体类型
            cell = row.getCell(3);
            String D = convertCellValueToString(cell);
            resultData.setType(D);

            // 第五列等级
            cell = row.getCell(4);
            String E = convertCellValueToString(cell);
            resultData.setLevel(E);

            // 第六列联系人
            cell = row.getCell(5);
            String F = convertCellValueToString(cell);
            if (F != null) {
                resultData.setPhone(Long.valueOf(F));
            }

            // 第七列建设内容及规模
            cell = row.getCell(6);
            String G = convertCellValueToString(cell);
            resultData.setContent(G);


            // 第八列总投资金额
            cell = row.getCell(7);
            String H = convertCellValueToString(cell);
            if (!H.equals("-")) {
                resultData.setInvest(Double.valueOf(H));
            }


            // 第九列申请补贴金额
            cell = row.getCell(8);

            String I = convertCellValueToString(cell);
            if (!I.equals("-")) {
                resultData.setApply(Double.valueOf(I));
            }


            // 第十列预计补贴金额
            cell = row.getCell(9);
            String J = convertCellValueToString(cell);
            if (!J.equals("-")) {
                resultData.setEstimate(Double.valueOf(J));
            }


            // 第十一列拟补贴金额  这一列是直接插入的，所以是空的？
            cell = row.getCell(10);
            String K = convertCellValueToString(cell);
            if (K != null && !K.equals("-")) {
                resultData.setProposed(Double.valueOf(K));
            }


            // 第十二列实际补贴金额
            cell = row.getCell(11);
            String L = convertCellValueToString(cell);
            if (!L.equals("-")) {
                resultData.setActual(Double.valueOf(L));
            }


            // 第十三列省
            cell = row.getCell(12);
            String M = convertCellValueToString(cell);
            resultData.setProvince(M);

            // 第十四列市
            cell = row.getCell(13);
            String N = convertCellValueToString(cell);
            resultData.setCity(N);

            // 第十五列区
            cell = row.getCell(14);
            String O = convertCellValueToString(cell);
            resultData.setDistrict(O);

            // 第十流列 是否贫困县
            cell = row.getCell(15);
            String P = convertCellValueToString(cell);
            resultData.setIsPoor(P);

            // 第十七列 是否建立在田头市场
            cell = row.getCell(16);
            String Q = convertCellValueToString(cell);
            resultData.setIsFarm(Q);

            // 第十八列 仓储产品
            cell = row.getCell(17);
            String R = convertCellValueToString(cell);
            resultData.setProducts(R);

            // 第十九列 创建时间
            cell = row.getCell(18);
            if (cell.getCellType().equals(CellType.STRING)) {
                String S = cell.getStringCellValue();
                if (!StringUtils.isBlank(S)) {
                    resultData.setCreate(LocalDateTime.parse(S, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }
            } else if (cell.getCellType().equals(CellType.NUMERIC)) {
                LocalDateTime localDateTimeCellValue = cell.getLocalDateTimeCellValue();
                resultData.setCreate(localDateTimeCellValue);
            }


            // 第二十列 审核时间
            cell = row.getCell(19);
            String T = convertCellValueToString(cell);
            if (!StringUtils.isBlank(T)) {
                resultData.setUpdate(LocalDateTime.parse(T, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }

            // 第二十一列 审核时间
            cell = row.getCell(20);
            String U = convertCellValueToString(cell);
            if (!StringUtils.isBlank(U)) {
                resultData.setStatus2(U);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultData;
    }

    /**
     * 将单元格内容转换为字符串
     *
     * @param cell
     * @return
     */
    private static String convertCellValueToString(Cell cell) {
        if (cell == null) {
            return null;
        }
        String returnValue = null;
        try {
            switch (cell.getCellType()) {
                case NUMERIC:   //数字
                    Double doubleValue = cell.getNumericCellValue();

                    // 格式化科学计数法，取一位整数
                    DecimalFormat df = new DecimalFormat("0");
                    returnValue = df.format(doubleValue);
                    break;
                case STRING:    //字符串
                    returnValue = cell.getStringCellValue();
                    break;
                case BOOLEAN:   //布尔
                    Boolean booleanValue = cell.getBooleanCellValue();
                    returnValue = booleanValue.toString();
                    break;
                case BLANK:     // 空值
                    break;
                case FORMULA:   // 公式
                    returnValue = cell.getCellFormula();
                    break;
                case ERROR:     // 故障
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

}
