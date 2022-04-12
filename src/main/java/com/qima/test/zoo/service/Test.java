package com.qima.test.zoo.service;

import com.alibaba.fastjson.JSONObject;
import com.qima.test.zoo.bean.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<String> ids = animals.stream().map(Animal::getId).collect(Collectors.toList());
    }
}
