package com.wangfengbabe.demo.jvm.understandjvm.thread.AboutGc;

public class TestDeadLock {

    static class SynAddRunnable implements Runnable {

        int a, b;

        public SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        //循环稍微大一点儿就容易出现死锁
        for (int i = 0; i < 200; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }

}
