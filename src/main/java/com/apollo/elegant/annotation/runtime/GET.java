package com.apollo.elegant.annotation.runtime;

import java.lang.annotation.*;

/**
 * @author dingyubin
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GET {
    String value() default "";
}
