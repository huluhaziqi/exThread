package yield;

public class YieldTest {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.setPriority(6);
        mythread.start();
    }
}

class Mythread extends Thread {
    private int count = 0;

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int i = 0;
        while (i++ < 500000000) {
            Thread.yield();
            count++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("时间 ：" + (endTime - beginTime));
    }
}
