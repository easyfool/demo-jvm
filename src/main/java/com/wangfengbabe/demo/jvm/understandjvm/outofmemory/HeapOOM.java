package com.wangfengbabe.demo.jvm.understandjvm.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 将堆的最小值-Xms参数与最大值
 * -Xmx参数设置为一样就可以避免堆自动扩展(java堆不可扩展的方法)
 */
public class HeapOOM {

    static class OOMObject {


    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }

    }
}
