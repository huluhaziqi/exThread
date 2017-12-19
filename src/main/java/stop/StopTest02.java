package stop;

public class StopTest02 {
    public static void main(String[] args) {
        MyThread11 myThread11 = new MyThread11();
        myThread11.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class MyThread11 extends Thread{
    private int count = 0;

    @Override
    public void run() {
        try {
            this.stop();
        } catch (Exception e) {
            System.out.println("run catch");
            e.printStackTrace();
        }
    }
}