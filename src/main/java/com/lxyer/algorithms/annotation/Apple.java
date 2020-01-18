package com.lxyer.algorithms.annotation;

import lombok.Data;

@Data
public class Apple {
    @FruitName("apple")
    private String name;
    @FruitColor(fruitColor = FruitColor.Color.GREEN)
    private String color;


}
