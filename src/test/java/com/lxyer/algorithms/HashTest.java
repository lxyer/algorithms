package com.lxyer.algorithms;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class HashTest {
    /**
     * 需要重写equals方法的场景:主要依据我们的业务场景来看,例如:当我们对Coder这个对象进行判断的时候,我们不需要Coder的所有的
     * 属性都必须相同,则可以重写Coder的equals方法,和hashCode()方法
     */
    @Test
    public void hashCodeTest() {
        Coder coder = new Coder("lxyer", 22);
        Coder coder1 = new Coder("lxyer", 221);
        Coder coder2 = new Coder();
        coder2.setAge(222);
        coder2.setName("lxyer");
        System.out.println(coder.hashCode());
        System.out.println(coder1.hashCode());
        System.out.println(coder2.hashCode());
        System.out.println(coder.equals(coder2));
        Set set = new HashSet();
        set.add(coder);
        set.add(coder1);
        set.add(coder2);
        System.out.println(set.size());
    }

    @Data
    public class Coder {
        private String name;
        private int age;

        public Coder() {
        }

        public Coder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (o == this) {
                return true;
            }
            if (o.getClass() != this.getClass()) {
                return false;
            }
            Coder other = (Coder) o;
            if (other.getName() == this.getName()) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            //hash使用素数
            int hash = 17;
            return hash * 31 + getName().hashCode();
        }
    }
}
