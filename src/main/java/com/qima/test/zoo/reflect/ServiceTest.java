package com.qima.test.zoo.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author A80390
 */
public class ServiceTest {

    public static void main(String[] args) {
        try {
            File file = new File("F:\\gree-project\\zoo-main\\src\\main\\java\\com\\qima\\test\\zoo\\reflect\\spring.txt");
            Properties config = new Properties();
            config.load(new FileInputStream(file));
            String className = (String) config.get("className");
            String methodName = (String) config.get("methodName");

            //获取类对象
            Class clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName);
            //获取构造器
            Constructor con = clazz.getConstructor();
            //根据构造器实例化
            Object service = con.newInstance();
            method.invoke(service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
