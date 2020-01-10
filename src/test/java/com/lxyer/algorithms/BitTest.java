package com.lxyer.algorithms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.BitSet;

@SpringBootTest
public class BitTest {
    //0到10000中随机出1000个数，然后用位图算法排序：
    @Test
    public void bitSetTest(){
        int count  = 10000;
        BitSet set = new BitSet(count);
        System.out.println(Math.random());
        int i = 1000;
        while (i > 0) {
            System.out.println((int) Math.random() * count);
            set.set((int) Math.random() * count);
            i--;
        }
        for (int index = 0; index < count; index++) {
            if (set.get(index)) {
                System.out.println(index + ",");
            }
        }
    }
}
