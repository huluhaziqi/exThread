package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class lockTest03 {

    public static void main(String[] args) {

        try {
            Service01 service01 = new Service01();
            Thread04 thread04 = new Thread04(service01);
            Thread05 thread05 = new Thread05(service01);

            thread04.start();
            thread05.start();

            Thread.sleep(3000);

            service01.signalA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Service01 {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition conditionA = reentrantLock.newCondition();
    private Condition conditionB = reentrantLock.newCondition();

    public void awaitA() {
        try {
            reentrantLock.lock();
            System.out.println("await a begin " + System.currentTimeMillis());
            conditionA.await();
            System.out.println("await a end " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void awaitB() {
        try {
            reentrantLock.lock();
            System.out.println("await b begin " + System.currentTimeMillis());
            conditionB.await();
            System.out.println("await b end " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void signalA() {
        try {
            reentrantLock.lock();
            System.out.println("signal a " + System.currentTimeMillis());
            conditionA.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void signalB() {
        try {
            reentrantLock.lock();
            System.out.println("signal b " + System.currentTimeMillis());
            conditionB.signal();
        } finally {
            reentrantLock.unlock();
        }
    }
}

class Thread04 extends Thread {
    private Service01 service01;

    public Thread04(Service01 service01) {
        this.service01 = service01;
    }

    @Override
    public void run() {
        service01.awaitA();
    }
}

class Thread05 extends Thread {
    private Service01 service01;

    public Thread05(Service01 service01) {
        this.service01 = service01;
    }

    @Override
    public void run() {
        service01.awaitB();
    }
}