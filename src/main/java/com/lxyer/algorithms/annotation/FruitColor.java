package com.lxyer.algorithms.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color{BULE,RED,GREEN}

    Color fruitColor() default Color.RED;

}
