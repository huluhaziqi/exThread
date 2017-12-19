package priority;

public class PriorityTest01 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        MyThread myThread1 = new MyThread();
        myThread1.start();
        MyThread myThread = new MyThread();
        myThread.setPriority(10);
        myThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread priority " + this.getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1 priority " + this.getPriority());
    }
}
