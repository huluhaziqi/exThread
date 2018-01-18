package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerAndProducter {

    public static void main(String[] args) {
        Service02 service02 = new Service02();
        Thread11 thread11 = new Thread11(service02);
        thread11.start();
        Thread10 thread10 = new Thread10(service02);
        Thread10 thread101 = new Thread10(service02);
        Thread10 thread102 = new Thread10(service02);
        Thread10 thread103 = new Thread10(service02);
        Thread10 thread104 = new Thread10(service02);
        thread10.start();
        thread101.start();
        thread102.start();
        thread103.start();
        thread104.start();
    }
}


class Thread10 extends Thread {
    private Service02 service02;

    public Thread10(Service02 service02) {
        this.service02 = service02;
    }

    @Override
    public void run() {
        while (true) {
            service02.get();
        }
    }
}

class Thread11 extends Thread {
    private Service02 service02;

    public Thread11(Service02 service02) {
        this.service02 = service02;
    }

    @Override
    public void run() {
        while (true) {
            service02.set();
        }
    }
}

class Service02 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            if (hasValue == true) {
                System.out.println(Thread.currentThread().getName() + "_set await");
                condition.await();
            }
            System.out.println("打印*");
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            if (hasValue == false) {
                System.out.println(Thread.currentThread().getName() + "_get await");
                condition.await();
            }
            System.out.println("打印#");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
