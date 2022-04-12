package com.qima.test.zoo.reflect;

/**
 * @author A80390
 */
public class ObjectTest {
    public static void main(String[] args) {
        try {
            //获取类对象的第一种方式
            String className = "com.qima.test.zoo.reflect.Hero";
            Class sClass1 = Class.forName(className);
            System.out.println("sClass1:" + sClass1);
            //获取类对象的第二种方式
            Class sClass2 = Hero.class;
            System.out.println("sClass2:" + sClass2);
            //获取类对象的第三种方式
            Class sClass3 = new Hero().getClass();
            System.out.println("sClass3:" + sClass3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
