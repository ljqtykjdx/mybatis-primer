package com.imooc.mybatis.cache;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
//
//public class MyClass {
//    private int x;
//    private int y;
//
//    public MyClass(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    private int myMethod() {
//        return x + y;
//    }
//
//    public static void main(String[] args) throws Exception {
//        // Create an instance of MyClass
//        MyClass obj = new MyClass(1, 2);
//
//        // Use reflection to print out the names and values of all the fields in the object
//        Field[] fields = obj.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            System.out.println(field.getName() + " = " + field.get(obj));
//        }
//
//        // Use reflection to invoke a private method for testing purposes
//        Method method = obj.getClass().getDeclaredMethod("myMethod");
//        method.setAccessible(true);
//        int result = (int) method.invoke(obj);
//        System.out.println("Result of myMethod: " + result);
//    }
//}

//
//public class MyClass {
//    private ylzrFanShe.MyDependency dependency;
//
//    public MyClass(ylzrFanShe.MyDependency dependency) {
//        this.dependency = dependency;
//    }
//
//    public void doSomethingWithDependency() {
//        dependency.doSomething();
//    }
//}