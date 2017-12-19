package SuspendAndResume;

public class RunTest {


    /**
     *     容易造成数据sespend锁得不到释放而永远挂起，
     */

    public static void main(String[] args) {
        final SynchronizedObject object = new SynchronizedObject();
        Thread thread = new Thread() {
            @Override
            public void run() {
                object.print();
            }
        };
        thread.setName("a");
        thread.start();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("I am b");
                object.print();
            }
        };
        thread1.setName("b");
        thread1.start();
    }
}

class SynchronizedObject {
    public synchronized void print() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("永远的锁住了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}

