package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockTest01 {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread01 thread01 = new Thread01(lock);
        Thread02 thread02 = new Thread02(lock);
        thread01.start();
        thread02.start();

    }
}

class Thread01 extends Thread {
    private Lock lock;

    public Thread01(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("Thread01 run " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("Thread01 end " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}

class Thread02 extends Thread {
    private Lock lock;

    public Thread02(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("Thread02 run " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("Thread02 end " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
