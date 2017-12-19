package com.lin.exThread.test;

public class Main {

    public static void main(String[] args) {
        MyThread2 test = new MyThread2();
        System.out.println(test.isAlive());
        test.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.isAlive());
    }
}
