package single;

public class MyThread02 extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject02.getMyObject02().hashCode());
    }
}
