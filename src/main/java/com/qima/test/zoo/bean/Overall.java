package com.qima.test.zoo.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Overall {
    private long aliveCount;
    private long deadCount;
    private String lightestOne;
    private String shortestOne;
    private String oldestOne;
}
