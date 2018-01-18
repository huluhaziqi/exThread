package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class lockTest02 {
    public static void main(String[] args) {
        try {
            MyService myService = new MyService();

            ThreadLock1 threadLock1 = new ThreadLock1(myService);
            threadLock1.start();
            Thread.sleep(2000);
            myService.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadLock1 extends Thread {
    private MyService myService;

    public ThreadLock1(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }
}

class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println("await time _" + System.currentTimeMillis());
            condition.await();
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("释放锁");
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal time _" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }

    }

}