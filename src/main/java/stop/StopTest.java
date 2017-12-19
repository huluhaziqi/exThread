package stop;

public class StopTest {
    public static void main(String[] args) {
        MyThread05 myThread05 = new MyThread05();
        myThread05.start();
        myThread05.interrupt();
        //this.isInterrupted()不具备清楚状态标记的功能，不是static方法
        System.out.println("myThread05 is interrupt() : " + myThread05.isInterrupted());
        System.out.println("myThread05 is interrupt() : " + myThread05.isInterrupted());
        System.out.println("myThread05 is interrupt() : " + myThread05.isInterrupted());
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
//            this.interrupt();
//            System.out.println(Thread.interrupted());
//            //Thread.interrupted()具备清楚中断状态的功能，因此第二次使用的时候中断状态为false；
//            System.out.println(Thread.interrupted());
        }
    }
}
