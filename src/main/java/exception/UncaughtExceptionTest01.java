package exception;

public class UncaughtExceptionTest01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程" + t.getName() + " 出现了异常");
                e.printStackTrace();
            }
        });
        myThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        String username = null;
        System.out.println(username.hashCode());
    }
}