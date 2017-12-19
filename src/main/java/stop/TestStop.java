package stop;

public class TestStop {

    public static void main(String[] args) {
        MyThread10 myThread10 = new MyThread10();
        myThread10.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //不推荐使用
        try {
            myThread10.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class MyThread10 extends Thread{
    private int i = 0;

    @Override
    public void run() {
        while (true){
            System.out.println("i = " + (i++));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
