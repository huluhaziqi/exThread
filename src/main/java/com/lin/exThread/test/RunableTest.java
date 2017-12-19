package com.lin.exThread.test;

class RunableTest implements Runnable {
    private int count = 10;
    public void run() {
        System.out.println("start");
        for(int i = 0; i < 5; i++) {
            System.out.println(count--);
        }
        System.out.println("end");
    }
}


