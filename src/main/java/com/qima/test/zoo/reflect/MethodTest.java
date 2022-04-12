package com.qima.test.zoo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 获取成员方法并使用
 * @author A80390
 */
public class MethodTest {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.qima.test.zoo.reflect.HeroPlus");
            //获取构造方法
            Constructor con = clazz.getConstructor();
            Object object = con.newInstance();
            //获取名字是setName 参数类型是String的方法
            Method m = clazz.getMethod("setName", String.class);
            //调用这个方法
            m.invoke(null, "盖伦");
            m = object.getClass().getMethod("getName");
            String name = (String) m.invoke(null);
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
