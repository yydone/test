package com.yydone.test;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class StreamTest {

    public static void main(String []args) {
        for(int i=0; i<1000;i++) {
            write();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void write() {
        File ruleFile = new File("d:/stream.txt");
        if (ruleFile.exists()) {
            ruleFile.delete();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(bos);
        String sourceText;
        FileWriter fw = null;
        try {
            out.append("1.1、OutputStream：表示输出字节流所有类的超类。输出流接受输出字节并将它们发送到某个接收器。一般我们使用它的子类,如FileOutputStream等.\n" +
                    "\n" +
                    "1.2、OutputStreamWriter：OutputStreamWriter是从字符流到字节流的桥接：写入它的字符使用指定的字节编码为字节字符集。它使用的字符集可以通过名称指定，也可以明确指定，或者可以接受平台的默认字符集。\n" +
                    "\n" +
                    "每次调用write（）方法都会导致在给定字符上调用编码转换器。生成的字节在写入底层输出流之前在缓冲区中累积。可以指定此缓冲区的大小，但默认情况下，它足够大，可用于大多数用途。请注意，传递给write（）方法的字符不会被缓冲。为了获得最高效率，请考虑在BufferedWriter中包装OutputStreamWriter，以避免频繁的转换器调用\n" +
                    "\n" +
                    "例如： Writer out = new BufferedWriter(new OutputStreamWriter(System.out));\n" +
                    "--------------------- \n" +
                    "作者：有头发的猩猩 \n" +
                    "来源：CSDN \n" +
                    "原文：https://blog.csdn.net/m0_37574389/article/details/84024689 \n" +
                    "版权声明：本文为博主原创文章，转载请附上博文链接！\n");
            out.append("hello world 中华人民共和国\n");
            out.append("hello world 中华人民共和国\n");
            out.append("hello world 中华人民共和国\n");
            out.append("hello world 中华人民共和国\n");
            out.append("hello world 中华人民共和国\n");
            out.append("hello world 中华人民共和国\n");
            out.append("hello world 中华人民共和国\n");
            out.append("hello world 中华人民共和国\n");
            out.append("hello world 中华人民共和国\n");
            out.append("hello world 中华人民共和国\n");
            out.flush();
            sourceText = new String(bos.toByteArray(), "UTF-8");
            fw = new FileWriter(ruleFile);
            fw.write(sourceText);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                }
            }
           /* if(out !=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }
}
