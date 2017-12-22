package notifyAndWait;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class test01 {
    public static void main(String[] args) {
        Object lock = new Object();
        MyThread01 myThread01 = new MyThread01(lock);
        myThread01.start();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MyThread02 myThread02 = new MyThread02(lock);
        myThread02.start();

    }
}

class MyList {
    private static List<Object> list = new ArrayList<Object>();

    public static void add(Object x) {
        list.add(x);
    }

    public static int size() {
        return list.size();
    }
}

class MyThread01 extends Thread {
    private Object lock;

    public MyThread01(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("start of thread01 " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("end of thread01 "+ System.currentTimeMillis());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MyThread02 extends Thread {
    private Object lock;
    public MyThread02(Object lock){
        this.lock = lock;
    }
    @Override
    public void run() {
        try {
            synchronized(lock){
                for(int i = 0; i < 10; i++){
                    MyList.add(new Object());
                    if(i == 5){
                        lock.notify();
                        System.out.println("发出通知 " + + System.currentTimeMillis());
                    }
                    System.out.println("添加了" + (i+1) + "个元素");
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}