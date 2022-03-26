package com.apollo.elegant.annotation.swordsman.default1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author dingyubin
 */
@Retention(RetentionPolicy.CLASS)
public @interface Swordsman {
    String name() default "张无忌";
    int age() default 18;
}
