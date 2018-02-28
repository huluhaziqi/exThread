package exception;

public class Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
        MyThread.setDefaultUncaughtExceptionHandler(new StatUncaughtExceptionHandler());
        myThread.start();
    }

}
