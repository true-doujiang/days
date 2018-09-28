package com.yhh.queue.day080928;


import java.util.Scanner;

public class BoundedBufferTest {

    public static void main(String[] args) {

        final BoundedBuffer buffer = new BoundedBuffer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Object x = null;
                    while ((x = buffer.take()) != null) {
                        System.err.println(Thread.currentThread().getName() + "消+++++费 " + x);
                    }
                    System.err.println(Thread.currentThread().getName() + " over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer111111111").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Object y = null;
                    while ((y = buffer.take()) != null) {
                        System.err.println(Thread.currentThread().getName() + "消-----费 " + y);
                    }
                    System.err.println(Thread.currentThread().getName() + " over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer222222222").start();



        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
           final int x = scanner.nextInt();
            System.out.println("input x = " + x);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i =1; i<= x; i++) {
                            synchronized (BoundedBufferTest.class) {
                                String x = "特朗普"+ i;
                                buffer.put(x);
                                System.out.println(Thread.currentThread().getName() + " 生产 " + x);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " over");
                }
            }, "=============== Productor1").start();
        }


    }

}
