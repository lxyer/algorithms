package com.lxyer.algorithms.annotation;

import com.sun.istack.internal.Interned;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color{BULE,RED,GREEN}

    Color fruitColor() default Color.RED;

}
