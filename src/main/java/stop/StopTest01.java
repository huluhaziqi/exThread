package stop;

public class StopTest01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();
        System.out.println("end");
    }
}

class MyThread extends Thread  {
    private int count = 10;

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("mythread 停滞状态");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
            }
            System.out.println("我在for下面");
        } catch (InterruptedException e) {
            System.out.println("进入MyThread run catch 方法中");
            e.printStackTrace();
        }
    }
}
