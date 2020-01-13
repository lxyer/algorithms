package com.lxyer.algorithms.code;

public class NumDemo {
    public static void main(String[] args) {

    }

    /**
     * 判断该数字是不是2的整数次幂
     * @param num
     * @return
     */
    public static boolean isPowerOf2(int num){
        return (num & num - 1) == 0;
    }
}
