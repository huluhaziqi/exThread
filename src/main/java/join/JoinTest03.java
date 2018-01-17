package join;

public class JoinTest03 {
    public static void main(String[] args) {
        try {
            ThreadTest01 threadTest01 = new ThreadTest01();
            ThreadTest02 threadTest02 = new ThreadTest02(threadTest01);
            threadTest02.start();
            Thread.sleep(1000);
            ThreadTest03 threadTest03 = new ThreadTest03(threadTest01);
            threadTest03.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadTest01 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("打印 1 _start_" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("打印 1 _end_" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void bService() {
        System.out.println("打印 3 time_" + System.currentTimeMillis());
    }
}

class ThreadTest02 extends Thread {
    private ThreadTest01 threadTest01;

    public ThreadTest02(ThreadTest01 threadTest01) {
        this.threadTest01 = threadTest01;
    }

    @Override
    public void run() {
        try {
            synchronized (threadTest01) {
                threadTest01.start();
//                Thread.sleep(6000);
                threadTest01.join();
                //持有01的锁达到6秒
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadTest03 extends Thread {
    private ThreadTest01 threadTest01;

    public ThreadTest03(ThreadTest01 threadTest01) {
        this.threadTest01 = threadTest01;
    }

    @Override
    public void run() {
        threadTest01.bService();
    }
}