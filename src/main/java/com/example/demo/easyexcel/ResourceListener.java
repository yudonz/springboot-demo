package com.example.demo.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.example.demo.entity.AdmRightTemplate;
import com.example.demo.entity.ResourceRead;
import com.example.demo.mapper.AdmRightTemplateMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 15:48
 * @description：
 */
@Slf4j
public class ResourceListener extends AnalysisEventListener<ResourceRead> {

    private AdmRightTemplateMapper admRightTemplateMapper;
    //private List<ResourceRead> list = new ArrayList<>();
    private List<AdmRightTemplate> templates = new ArrayList<>();

    public ResourceListener(AdmRightTemplateMapper admRightTemplateMapper) {
        this.admRightTemplateMapper = admRightTemplateMapper;
    }
    //private Map<String, List<AdmRightTemplate>> map = new HashMap<>();

    @Override
    public void invoke(ResourceRead data, AnalysisContext analysisContext) {
        log.info("读取数据：" + JSON.toJSON(data));


        AdmRightTemplate template = getTemplate(data);
        if (template != null) {
            template.setDepartmentId(2);
            template.setDepartmentName("合作社");
            template.setLevel((byte) 1);
            templates.add(template);
        }
    }

    private AdmRightTemplate getTemplate(ResourceRead data) {
        if (!StringUtils.isBlank(data.getArtelprovince())) {

            AdmRightTemplate template = new AdmRightTemplate();
            template.setCreateTime(new Date());

            if (!StringUtils.isBlank(data.getCname())) {
                template.setResourceId(data.getCid());
                template.setResourceName(data.getCname());
            } else if (!StringUtils.isBlank(data.getBname())) {
                template.setResourceId(data.getBid());
                template.setResourceName(data.getBname());
            } else if (!StringUtils.isBlank(data.getAname())) {
                template.setResourceId(data.getAid());
                template.setResourceName(data.getAname());
            } else {
                log.info("空行");
            }
            log.info("导出数据：" + JSON.toJSON(template));
            return template;
        }
        return null;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        String fileName = "C:\\Users\\Administrator\\Desktop\\导出的模板.xlsx";
        //EasyExcel.write(fileName, AdmRightTemplate.class).sheet("合作社-省").doWrite(templates);

        //save();
    }

    private void save() {
        if (admRightTemplateMapper != null) {
            admRightTemplateMapper.insertList(templates);
        }
    }


}
