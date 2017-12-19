package SuspendAndResume;

public class SuspendAndResumeTest {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();

            Thread.sleep(2000);

            //暂停
            System.out.println("suspend");
            myThread.suspend();
            System.out.println(myThread.getI() + " " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(myThread.getI() + " " + System.currentTimeMillis());
            System.out.println("resume");
            myThread.resume();
            System.out.println(myThread.getI() + " " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(myThread.getI() + " " + System.currentTimeMillis());
            System.out.println("suspend");
            myThread.suspend();
            System.out.println(myThread.getI() + " " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(myThread.getI() + " " + System.currentTimeMillis());
            System.out.println("resume");
            myThread.resume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class MyThread extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}