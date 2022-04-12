package com.qima.test.zoo.reflect;

import java.lang.reflect.Constructor;

/**
 * @author A80390
 */
public class ReflectObject {
    public static void main(String[] args) {
        try {
            //利用反射机制创建对象
            String className = "com.qima.test.zoo.reflect.Hero";
            //获取类对象
            Class class1 = Class.forName(className);
            System.out.println("class1:" + class1);

            System.out.println("************************所有公有构造方法*******************");
            Constructor[] conArray = class1.getConstructors();
            for (Constructor c : conArray) {
                System.out.println(c);
            }

            System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
            conArray = class1.getDeclaredConstructors();
            for (Constructor c : conArray) {
                System.out.println(c);
            }

            System.out.println("*****************获取公有、无参的构造方法*******************************");
            Constructor con = class1.getConstructor();
            System.out.println(con);
            Object obj = con.newInstance();

            System.out.println("******************获取私有构造方法，并调用*******************************");
            con = class1.getDeclaredConstructor(float.class);
            System.out.println(con);
            //暴力访问 忽略修饰词
            con.setAccessible(true);
            obj = con.newInstance(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
