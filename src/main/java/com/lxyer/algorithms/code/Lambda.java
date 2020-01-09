package com.lxyer.algorithms.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        //出所有 长度>=5的字符串，并且忽略大小写、去除重复字符串，然后按字母排序，最后用“爱心❤”连接成一个字符串输出！
        String [] list = {"1", "2", "bilibili", "of", "codesheep", "5", "at", "BILIBILI", "codesheep", "23", "CHEERS", "6"};
        //使用Java 8 提供的Stream流式操作
        String result = Arrays.asList(list).stream()// 首先将列表转化为Stream流
                .filter(i->!isNum(i))// 首先筛选出字母型字符串
                .filter(i->i.length()>=5)// 其次筛选出长度>=5的字符串
                .map(i->i.toLowerCase())// 字符串统一转小写
                .distinct()// 去重操作来一下
                .sorted(Comparator.naturalOrder())// 字符串排序来一下
                .collect(Collectors.joining("❤"));// 连词成句来一下，完美！
        System.out.println(result);

        /**
         * 无参lambda
         */
        new Thread(() -> System.out.println("Hello Lambda!")).start();

    }
    public static Boolean isNum( String str ) {
        for( int i=0; i<str.length(); i++ ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
