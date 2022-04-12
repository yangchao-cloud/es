package com.qima.test.zoo.controller;

import com.qima.test.zoo.entity.Student;
import com.qima.test.zoo.utils.ExcelUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A80390
 */
@RestController
@RequestMapping(value = "/export")
public class ExportExcel {
    @GetMapping(value = "/excel")
    public void exportXls(HttpServletResponse response) throws IOException {
        Student student1 = Student.builder().age(24).sex(1).name("阳超").grade("一年级").build();
        Student student2 = Student.builder().age(24).sex(2).name("向思琪").grade("一年级").build();
        // 查询数据
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        // 导出数据，数据，数据类型，文件名称，表名，响应对象
        ExcelUtils.exportExcel(list, "学生信息表", "学生信息", Student.class, "学生信息", response);
    }
}
