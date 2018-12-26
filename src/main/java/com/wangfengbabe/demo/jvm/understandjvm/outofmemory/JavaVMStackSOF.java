package com.wangfengbabe.demo.jvm.understandjvm.outofmemory;

/**
 * VM Args: -Xss200k
 *
 * -Xss 栈内存
 * 1. 使用-Xss 参数减少栈内存容量。结果：抛出StackOverFlowError异常，异常出现时输出的堆栈深度相应缩小
 * 2. 定义大量的本地变量，增大此方法帧中本地变量表的长度。结果：抛出StackOverFlowError异常，异常出现时输出的堆栈深度相应缩小
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length :" + oom.stackLength);
            throw e;

        }

    }

}
