package stop;

public class StopTest {
    public static void main(String[] args) {
        MyThread05 myThread05 = new MyThread05();
        myThread05.start();
        myThread05.interrupt();
        System.out.println("myThread05 is interrupt() : " + myThread05.isInterrupted());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.currentThread().interrupt();
        System.out.println("是否停止 ： =====" + Thread.interrupted());
    }
}

class MyThread05 extends Thread {
    private int count = 10;

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            System.out.println("i = " + i);
            this.interrupt();
            System.out.println(Thread.interrupted());
        }
    }
}
