package com.lin.exThread.test;

public class TestIsAlive {
    /**
     * thread 构造函数运行在main线程
     * run方法是main线程中运行，而start方法是this中运行
     * @param args
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
        myThread.start();
    }
}

class MyThread extends Thread {

    public MyThread() {
        System.out.println("--------start---------");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isAlive());
        System.out.println("--------end------------");
        System.out.println("--------start---------");
        System.out.println(this.getName());
        System.out.println(this.isAlive());
        System.out.println("--------end------------");
    }

    @Override
    public void run() {
        System.out.println("--------start---------");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isAlive());
        System.out.println("--------end------------");
        System.out.println("--------start---------");
        System.out.println(this.getName());
        System.out.println(this.isAlive());
        System.out.println("--------end------------");
    }
}