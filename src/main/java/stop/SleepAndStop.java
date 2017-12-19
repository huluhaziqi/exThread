package stop;

public class SleepAndStop {
    public static void main(String[] args) {
        MyThread06 myThread06 = new MyThread06();
        myThread06.start();
//        try {
        try {
            Thread.sleep(200);
            myThread06.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main ");
            e.printStackTrace();
        }
//            Thread.currentThread().interrupt();
//        } catch (InterruptedException e) {
//            System.out.println("main sleep时候中断!");
//            e.printStackTrace();
//        }
    }
}

class MyThread06 extends Thread {
    private int count = 1000;

    @Override
    public void run() {
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            System.out.println("睡眠条件下停止 ！ 进入catch ！" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
