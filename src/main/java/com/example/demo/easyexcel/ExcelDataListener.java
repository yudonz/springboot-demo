package com.example.demo.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.demo.utils.CopyUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 15:48
 * @description：
 */

public class ExcelDataListener extends AnalysisEventListener<ExcelData> {

    private List<ExcelData> list = new ArrayList<>();
    private ExcelData temp;
    private List<Resource> resources;
    private List<NewData> newDataList;

    public ExcelDataListener(List<Resource> resources) {
        this.resources = resources;
    }


    @Override
    public void invoke(ExcelData data, AnalysisContext analysisContext) {

        if (StringUtils.isBlank(data.getDept()) && StringUtils.isBlank(data.getRange())
                && StringUtils.isBlank(data.getPost())) {
            //System.out.println("空行");
        } else if (StringUtils.isBlank(data.getDept()) && StringUtils.isBlank(data.getRange())
                && !StringUtils.isBlank(data.getPost())) {
            data.setDept(temp.getDept());
            data.setRange(temp.getRange());
            //System.out.println(data);
        } else if (StringUtils.isBlank(data.getDept()) && !StringUtils.isBlank(data.getRange())) {
            data.setDept(temp.getDept());
            //System.out.println(data);
            temp = data;
        } else if (!StringUtils.isBlank(data.getDept()) && !StringUtils.isBlank(data.getRange())) {
            //System.out.println(data);
            temp = data;
        }

//        if (!StringUtils.isBlank(data.getManageQuery())){
//            data.setManageQuery("查询");
//        }
//        if (!StringUtils.isBlank(data.getManageRead())){
//            data.setManageRead("查看");
//        }
//        if (!StringUtils.isBlank(data.getTrialQuery())){
//            data.setTrialQuery("导出Excel文件");
//        }
//        if (!StringUtils.isBlank(data.getTrialRead())){
//            data.setTrialRead("评级取消");
//        }
        System.out.println(data);
        list.add(data);

        NewData data1 = new NewData();
        try {
            CopyUtils.copy(data, data1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (resources == null) {
            return;
        }
        for (Resource resource : resources) {
            if (data1.getManageQuery().equals(resource.getCName())
                    && resource.getBName().equals("经营主体")) {
                data1.setManageQueryId(resource.getCid());
            }
        }

    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
