package com.qima.test.zoo.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 越过泛型检查
 * @author A80390
 */
public class GenericityTest {
    public static void main(String[] args) {
        try {
            ArrayList<String> list = new ArrayList<>();
            list.add("this");
            list.add("is");
            System.out.println("***************越过泛型检查*******************");
            //获取ArrayList的Class对象，反向的调用add方法，添加数据
            Class listClass = list.getClass();
            //获取add方法
            Method m = listClass.getMethod("add", Object.class);
            m.invoke(list, 5);
            for (Object obj : list) {
                Class objClass = obj.getClass();
                System.out.println(objClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
