package com.apollo.elegant.annotation.runtime;

import java.lang.reflect.Method;

/**
 * 运行时注解器
 *     -- 反射机制
 * @author dingyubin
 */
public class AnnotationProcessor {
    public static void main(String[] args) {
        Method[] methods = AnnotationTest.class.getDeclaredMethods();
        for (Method m : methods){
            GET get = m.getAnnotation(GET.class);
            System.out.println(get.value());
        }
    }
}
