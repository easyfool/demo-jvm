package com.wangfengbabe.demo.jvm.understandjvm.outofmemory;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * * jdk 1.6 VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * * 而在jdk1.7之后则while循环则会一直进行下去 要用-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects,
                        MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o, args);
                }
            });
            enhancer.create();

        }
    }

    static class OOMObject {

    }

}
