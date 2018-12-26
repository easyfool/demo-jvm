package com.wangfengbabe.demo.jvm.understandjvm.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * jdk 1.6 常量池分配在永久代
 * * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 而在jdk1.7之后则while循环则会一直进行下去
 * 要用-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用list保持着常量池引用，避免Full GC 回收常量池行为
        List<String> list = new ArrayList<>();
        // 10M 的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
