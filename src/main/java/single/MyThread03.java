package single;

public class MyThread03 extends Thread {
    @Override
    public void run() {
        System.out.println(SingleTon.getInstance().hashCode());
    }
}
