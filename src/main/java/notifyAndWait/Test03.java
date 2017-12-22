package notifyAndWait;

public class Test03 {
    /**
     * wait(long)在等待唤醒超时后自动唤醒
     * @param args
     */
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            MyThreadTest03_1 myThreadTest03_1 = new MyThreadTest03_1(lock);
            myThreadTest03_1.start();
            Thread.sleep(2000);
            MyThreadTest03_2 myThreadTest03_2 = new MyThreadTest03_2(lock);
            myThreadTest03_2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadTest03_1 extends Thread {
    private Object lock;

    public MyThreadTest03_1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("start " + System.currentTimeMillis());
                lock.wait(4000);
                System.out.println("end " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadTest03_2 extends Thread {
    private Object lock;

    public MyThreadTest03_2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("notify start " + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end " + System.currentTimeMillis());
            }
        } catch (Exception e) {

        }
    }
}