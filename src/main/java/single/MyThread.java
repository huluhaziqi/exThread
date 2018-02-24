package single;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getMyObject().hashCode());
    }
}
