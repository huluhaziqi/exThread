package exception;

public class ThreadGroupTest {
    public static void main(String[] args) {
        MyThreadGroup myThreadGroup = new MyThreadGroup("线程组");
        MyThread02[] myThread02s = new MyThread02[10];
        for (int i = 0; i < 10; i++) {
            myThread02s[i] = new MyThread02(myThreadGroup,"线程" + (i + 1) , String.valueOf(i + 1));
            myThread02s[i].start();
        }

        MyThread02 myThread02 = new MyThread02(myThreadGroup,"报错","a");
        myThread02.start();
    }
}

class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        this.interrupt();
    }
}

class MyThread02 extends Thread {
    private String num;

    public MyThread02(ThreadGroup group, String name, String num) {
        super(group, name);
        this.num = num;
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        while (this.isInterrupted() == false) {
            System.out.println("循环中" + Thread.currentThread().getName());
        }
    }
}