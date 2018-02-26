package single;

public class MyThread04 extends Thread {

    @Override
    public void run() {
        System.out.println(SingleTon3.getInstance().hashCode());
    }
}
