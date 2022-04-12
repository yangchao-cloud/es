package com.qima.test.zoo.bean;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ReportVO {

    public ReportVO() {

    }

    public ReportVO(Overall overall, Map<String, Long> size, Map<String, Long> sourceCountry, Map<String, Long> category) {
        this.overall = overall;
        this.size = size;
        this.sourceCountry = sourceCountry;
        this.category = category;
    }

    private Overall overall;
    private Map<String, Long> size;
    private Map<String, Long> sourceCountry;
    private Map<String, Long> category;
}
