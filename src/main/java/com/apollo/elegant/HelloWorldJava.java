package com.apollo.elegant;

import com.apollo.elegant.experiment.FlatMap;
import com.apollo.elegant.experiment.OperationImp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldJava {
    public static final long TYPE_HIED = 0X100000;

    public static void main(String[] args) {

        long v = 16;
        System.out.println(v | TYPE_HIED);


//        int total = 48;
//        int pageSize = 5;
//        System.out.println(total%pageSize);
//        System.out.println("Hello World, Apollo!");
//        System.out.println(0%3);
//        System.out.println(1%3);
//        System.out.println(2%3);
//        System.out.println(3%3);
//        System.out.println(4%3);
//        System.out.println(5%3);
//        System.out.println(6%3);
//        pop(FlatMap.class, OperationImp.class);
//        System.out.println(handleText1("明a的手机", 5));
//        System.out.println(handleText1("bcdefd", 5));

//        System.out.println(handleText("小明a的手机来来", 10));
//        System.out.println(handleText("abcdefghik", 10));
    }

    public static String handleText1(String content, int maxLen) {
//        if (TextUtils.isEmpty(content)) {
//            return content;
//        }

//        int count = 0;
        int endIndex = 0;
        for (int i = 0; i < content.length(); i++) {
            if (maxLen == endIndex++) {
               break;
            }
        }

        if (endIndex <= maxLen) {
            return content;
        } else {
            return content.substring(0, endIndex-2) + "...";
        }
    }

    public static String handleText(String content, int maxLen) {
//        if (TextUtils.isEmpty(content)) {
//            return content;
//        }

        int count = 0;
        int endIndex = 0;
        System.out.println(content.length());
        for (int i = 0; i < content.length(); i++) {
            char item = content.charAt(i);
            if (item < 128) {
                count = count + 1;
            } else {
                count = count + 2;
            }
            if (maxLen == count || (item >= 128 && maxLen + 1 == count)) {
                endIndex = i;
            }
        }

        if (count <= maxLen) {
            return content;
        } else {
            return content.substring(0, endIndex) + "...";
        }
    }

    public static void pop(Class<?>... fClass) {
        for (Class<?> c : fClass) {
            System.out.println(c.getCanonicalName());
        }
    }

    public static <E> List<E> copy(List<E> src) {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked")
            List<E> dest = (List<E>) in.readObject();
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<E>();
        }
    }

}
