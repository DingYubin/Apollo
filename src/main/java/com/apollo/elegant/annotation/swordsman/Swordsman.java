package com.apollo.elegant.annotation.swordsman;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author dingyubin
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Swordsman {
    String name();
    int age();
}
