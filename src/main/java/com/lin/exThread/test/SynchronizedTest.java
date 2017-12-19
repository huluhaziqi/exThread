package com.lin.exThread.test;

public class SynchronizedTest {
    public static void main(String[] args) {
//        MyThread2 myThread2 = new MyThread2();
//        MyThread2 myThread3 = new MyThread2();
//        MyThread2 myThread4 = new MyThread2();
//        MyThread2 myThread5 = new MyThread2();
//        MyThread2 myThread6 = new MyThread2();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
//        myThread5.start();
//        myThread6.start();

        MyThread2 myThread21 = new MyThread2();
        Thread thread1 = new Thread(myThread21, "A");
        Thread thread2 = new Thread(myThread21, "B");
        Thread thread3 = new Thread(myThread21, "C");
        Thread thread4 = new Thread(myThread21, "D");
        Thread thread5 = new Thread(myThread21, "E");
        Thread thread6 = new Thread(myThread21, "F");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

class MyThread2 extends Thread {
    private int count = 100;

    public MyThread2() {
//        System.out.println("----start of MyThread Construct");
//        System.out.println("Thread.currentThread().getName() :" + Thread.currentThread().getName()
//                + "Thread.currentThread().isAlive() : " + Thread.currentThread().isAlive());
//        System.out.println(this.getName() + " " + this.isAlive());
//        System.out.println("----end of MyThread Construct");

    }

    @Override
    public synchronized void run() {
        System.out.println("----start of MyThread run");
        System.out.println("Thread.currentThread().getName() :" + Thread.currentThread().getName()
                + "Thread.currentThread().isAlive() : " + Thread.currentThread().isAlive());
        System.out.println(this.getName() + " " + this.isAlive());
//        while (count > 0) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "  count :" + (count--));
        }
//        }
        System.out.println("----end of MyThread run");
    }
}
