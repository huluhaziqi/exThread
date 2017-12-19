package priority;

public class RunTest {

    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        myThread01.setPriority(Thread.NORM_PRIORITY - 3);
        MyThread02 myThread011 = new MyThread02();
        myThread011.setPriority(Thread.NORM_PRIORITY + 3);
        myThread01.start();
        myThread011.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread01.stop();
        myThread011.stop();
        System.out.println("myThread01 :" + myThread01.getCount());
        System.out.println("myThread011 :" + myThread011.getCount());


    }
}

class MyThread01 extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}
class MyThread02 extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}