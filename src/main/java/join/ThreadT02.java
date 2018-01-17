package join;

public class ThreadT02 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("begin b_" + Thread.currentThread().getName() + "_" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end b_" + Thread.currentThread().getName() + "_" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
