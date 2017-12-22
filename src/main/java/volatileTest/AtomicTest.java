package volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ServiceAtomicTest serviceAtomicTest = new ServiceAtomicTest();
        MyThreadAtmo[] myThreadAtmos = new MyThreadAtmo[5];
        for (int i = 0; i < myThreadAtmos.length; i++) {
            myThreadAtmos[i] = new MyThreadAtmo(serviceAtomicTest);
        }
        for (int i = 0; i < myThreadAtmos.length; i++) {
            myThreadAtmos[i].start();
        }
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " " + serviceAtomicTest.getAtomicInteger().intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ServiceAtomicTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public synchronized void add() {
        System.out.println("name = " + Thread.currentThread().getName() + " " + atomicInteger.addAndGet(100));
        atomicInteger.addAndGet(1);
    }

    public static AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public static void setAtomicInteger(AtomicInteger atomicInteger) {
        ServiceAtomicTest.atomicInteger = atomicInteger;
    }
}

class MyThreadAtmo extends Thread {
    private ServiceAtomicTest serviceAtomicTest;

    public MyThreadAtmo(ServiceAtomicTest serviceAtomicTest) {
        this.serviceAtomicTest = serviceAtomicTest;
    }

    @Override
    public void run() {
        serviceAtomicTest.add();
    }
}