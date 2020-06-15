package com.mushroom.day.demo20200615;

/**
 * @author 金海威
 * @version 1.0
 * @date 2020/6/15 21:42
 */
public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象
        Object obj = new Object();


        new Thread(() -> {
            //保证等待和唤醒的线程只能有一个执行
            while (true) {
                synchronized (obj) {
                    System.out.println("顾客1：告诉老板我要吃包子");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("包子已经做好了，顾客1开吃");
                }
            }
        }).start();

        new Thread(() -> {
            //保证等待和唤醒的线程只能有一个执行
            while (true) {
                synchronized (obj) {
                    System.out.println("顾客2：告诉老板我要吃包子");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("包子已经做好了，顾客2开吃");
                }
            }
        }).start();

        new Thread(() -> {
            //保证等待和唤醒的线程只能有一个执行
            while (true) {
//                System.out.println("laoban");
                synchronized (obj) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("老板5S后做好包子，告知消费者");
                    obj.notifyAll();
                    System.out.println("-----------------------");
                }
            }


        }).start();
    }
}
