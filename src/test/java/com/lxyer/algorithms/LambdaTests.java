package com.lxyer.algorithms;
import	java.util.stream.Collectors;
import java.util.Set;
import	java.util.function.Supplier;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@SpringBootTest
public class LambdaTests {
    /**
     * 1、()->{}，lambda参数、箭头、lambda主体缺一不可
     *
     * 2、参数类型可以省略，而且基本都是省略
     *
     * 3、lambda主体中如果只有一条语句可以省略大括号、return及结尾分号
     *
     * 4、方法引用可以作为lambda表达式
     */


    /**
     * 无参方法
     */
    @Test
    public void nonePara(){
        new Thread(() -> System.out.println("Hello Lambda!")).start();
    }
    /**
     * BiFunction接口
     */
    @Test
    public void biFunction(){
        System.out.println(get(1, 2, Integer::sum));
        System.out.println(get(1, 2, (a, b) -> a + b));
        System.out.println(get(1, 2, (a, b) -> a - b));

    }
    private static Integer get(Integer a,Integer b, BiFunction<Integer,Integer,Integer> biFunction){
        return biFunction.apply(a, b);
    }

    /**
     * 消费函数，返回值为void。
     */
    @Test
    public void consumer(){
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        //打印
        list.stream().forEach(i -> System.out.println(i));
        //添加元素
        List<Integer> list1 = new ArrayList<>();
        list.stream().filter(i -> list1.add(i));
    }
    /**
     * 断言/条件测试，定义一个抽象方法，必定有1个入参，返回值boolean。
     */
    @Test
    public void predicate(){
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        list.stream().filter(i->i>3);
    }

    /**
     * 不需要输入，产出T。像是一个容器，调用get返回对象。
     */
    @Test
    public void supplier(){
        Supplier<Long> supplier = new Supplier<Long>() {
            /**
             * Gets a result.
             *
             * @return a result
             */
            @Override
            public Long get() {
                return System.currentTimeMillis();
            }
        };
        System.out.println(supplier.get());
    }
    @Test
    public void test1(){
        List<String> list = Lists.newArrayList("hello", "how", "are", "you", "i", "am", "fine", "thank", "you", "and", "you");
        Set<Integer> set = list.stream().map(v -> v.length()).collect(Collectors.toSet());
        Set<Integer> set1 = list.stream().map(String::length).collect(Collectors.toSet());
        List<Integer> list1 = list.stream().map(String::length).collect(Collectors.toList());
        System.out.println(set);
        System.out.println(set1);
        System.out.println(list1);
    }
}
