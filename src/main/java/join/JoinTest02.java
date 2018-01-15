package join;

public class JoinTest02 {
    public static void main(String[] args) {
        Thread02 thread02 = new Thread02();
        thread02.start();
        Thread03 thread03 = new Thread03(thread02);
        thread03.start();
    }
}

class Thread01 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("a begin");
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread02 extends Thread {
    @Override
    public void run() {
        try {
            Thread01 thread01 = new Thread01();
            thread01.start();
            thread01.join();
            System.out.println("b ");
        } catch (InterruptedException e) {
            System.out.println("dadafds");
            e.printStackTrace();
        }
    }
}

class Thread03 extends Thread {

    private Thread02 thread02;

    public Thread03(Thread02 thread02) {
        this.thread02 = thread02;
    }

    @Override
    public void run() {
        thread02.interrupt();
    }
}

