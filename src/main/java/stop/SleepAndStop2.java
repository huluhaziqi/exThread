package stop;

public class SleepAndStop2 {

    public static void main(String[] args) {
        MyThread07 myThread07 = new MyThread07();
        myThread07.start();
        myThread07.interrupt();
        System.out.println("end");
    }
}

class MyThread07 extends Thread {
    private int count = 1000;

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + i);
        }
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            System.out.println("sleep 之前已经interrupt");
            e.printStackTrace();
        }
    }
}
