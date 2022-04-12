package com.qima.test.zoo.reflect;

import java.lang.reflect.Field;

/**
 * @author A80390 获取属性并修改
 */
public class ParaTest {
    public static void main(String[] args) {
        HeroPlus heroPlus = new HeroPlus();
        //使用传统方式修改属性
        heroPlus.setName("阳超");
        System.out.println(heroPlus.getName());

        try {
            Field field1 = heroPlus.getClass().getDeclaredField("name");
            System.out.println(field1.getName());
            field1.setAccessible(true);
            //修改这个属性的值
            field1.set(heroPlus, "向思琪");
            //打印被修改的值
            System.out.println(heroPlus.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
