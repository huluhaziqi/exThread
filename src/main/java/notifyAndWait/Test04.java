package notifyAndWait;

import java.util.ArrayList;
import java.util.List;

public class Test04 {
    public static void main(String[] args) {
        Object lock = new Object();
        Add add = new Add(lock);
        Sub sub = new Sub(lock);
        MyThreadTest04_1 myThreadTest04_1 = new MyThreadTest04_1(add);
        MyThreadTest04_2 myThreadTest04_2 = new MyThreadTest04_2(sub);
        MyThreadTest04_2 myThreadTest04_3 = new MyThreadTest04_2(sub);
        myThreadTest04_3.setName("sub A");
        myThreadTest04_3.start();
        myThreadTest04_2.setName("sub B");
        myThreadTest04_2.start();
        //
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThreadTest04_1.setName("add C");
        myThreadTest04_1.start();



    }
}

class MyThreadTest04_1 extends Thread {
    private Add a;

    public MyThreadTest04_1(Add a) {
        this.a = a;
    }

    @Override
    public void run() {
        a.add();
    }
}

class MyThreadTest04_2 extends Thread {
    private Sub sub;

    public MyThreadTest04_2(Sub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.sub();
    }
}

class Add {
    private Object lock;

    public Add(Object lock) {
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            ObjectList.list.add("sdfdsdf");
            lock.notifyAll();
        }
    }
}

class Sub {
    private Object lock;

    public Sub(Object lock) {
        this.lock = lock;
    }

    public void sub() {
        synchronized (lock) {
            try {
                while (ObjectList.list.size() == 0) {
                    System.out.println("start wait");
                    lock.wait();
                    System.out.println("end wait");
                }
                ObjectList.list.remove(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ObjectList {
    public static List list = new ArrayList();
}
