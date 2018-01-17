package join;

public class JoinTest04 {
    public static void main(String[] args) {
        try {
            ThreadT01 threadT01 = new ThreadT01();
            ThreadT02 threadT02 = new ThreadT02();
            threadT01.start();
            threadT02.start();
            threadT02.join(2000);
//            threadT02.join(2000);
            System.out.println("end of main" + "_" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadT01 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("begin a_" + Thread.currentThread().getName() + "_" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end a_" + Thread.currentThread().getName() + "_" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
