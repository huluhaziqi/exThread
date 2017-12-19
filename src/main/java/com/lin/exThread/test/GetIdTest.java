package com.lin.exThread.test;

public class GetIdTest {

    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();
        myThread4.start();
    }
}

class MyThread4 extends Thread {
    private int count = 10;

    @Override
    public void run() {
        System.out.println("name =" + Thread.currentThread().getName() + " id =  " + Thread.currentThread().getId());
    }
}
