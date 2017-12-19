package com.lin.exThread.test;

public class SleepTest {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        System.out.println("begin = " + System.currentTimeMillis());
        myThread3.start();
        System.out.println("end = " + System.currentTimeMillis());
    }
}

class MyThread3 extends Thread {
    private int count = 10;

    @Override
    public void run() {
        System.out.println("start MyThread3 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end MyThread3 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

    }
}
