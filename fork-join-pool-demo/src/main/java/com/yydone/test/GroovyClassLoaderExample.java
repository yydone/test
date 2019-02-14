package com.yydone.test;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;

import java.util.concurrent.*;

public class GroovyClassLoaderExample {

    public static void main(String[] args) {
        try {
            Class clazz;
            try (GroovyClassLoader loader = new GroovyClassLoader()) {
                clazz = loader.loadClass("com.yydone.test.Foo");
                /*clazz = loader.parseClass("package com.yydone.test\n" +
                        "\n" +
                        "class Foo implements IFoo {\n" +
                        "    Object add(Object x, Object y) {\n" +
                        "        return x + y\n" +
                        "    }\n" +
                        "}");*/
            }
            IFoo foo = (IFoo) clazz.newInstance();
            System.out.println( foo.add(new Integer(2), new Integer(3)));
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

