package Daemon;

public class DaemonTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");

    }
}

class MyThread extends Thread{
    private int count = 0;

    @Override
    public void run() {
        while (true){
            count++;
            System.out.println("count = " + count );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
