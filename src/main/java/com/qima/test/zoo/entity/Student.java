package com.qima.test.zoo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Builder;
import lombok.Data;

/**
 * @author A80390
 */
@Data
@Builder
public class Student {
    private Long id;
    @Excel(name = "年龄", width = 15)
    private Integer age;
    @Excel(name = "性别", width = 15, replace = {"男_1", "女_2"})
    private Integer sex;
    @Excel(name = "姓名", width = 15)
    private String name;
    @Excel(name = "年级", width = 15)
    private String grade;
}
