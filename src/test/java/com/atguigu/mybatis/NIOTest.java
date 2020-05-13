package com.atguigu.mybatis;

import org.junit.Test;

import java.nio.ByteBuffer;

public class NIOTest {
    @Test
    public void bufferTest(){
        String str = "abcdef";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());

        byteBuffer.put(str.getBytes());
        System.out.println("------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());

        byteBuffer.flip();
        System.out.println("------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());

    }
}
