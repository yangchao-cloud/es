package com.qima.test.zoo.reflect;

import java.lang.reflect.Method;

/**
 * 获取main方法并使用
 * @author A80390
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            //获取对象的字节码
            Class clazz = Class.forName("com.qima.test.zoo.reflect.HeroPlus");

            //获取main方法
            Method main = clazz.getMethod("main", String[].class);

            //调用main方法
            main.invoke(null, (Object) new String[]{"a", "b", "c"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
