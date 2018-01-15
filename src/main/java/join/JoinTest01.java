package join;

public class JoinTest01 {
    public static void main(String[] args) {
        try {
            JoinThread joinThread = new JoinThread();
            joinThread.start();
            joinThread.join();
            System.out.println("结束");
            //join  等待该线程被摧毁后才会执行后续的，就是阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class JoinThread extends Thread {
    @Override
    public void run() {
        try {
            int a = (int) (Math.random() * 10000);
            System.out.println(a);
            Thread.sleep(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}