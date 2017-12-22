package volatileTest;

public class VolatileTest02 {
    /**
     * 通过synchronized static 方法对类进行锁定，可以实现同步
     * 如果是使用volatile使用
     * @param args
     */
    public static void main(String[] args) {
        MyThreadTest02_1[] myThreadTest02_1 = new MyThreadTest02_1[100];
        for (int i = 0; i < 100; i++) {
            myThreadTest02_1[i] = new MyThreadTest02_1();
        }
        for (int i = 0; i < 100; i++) {
            myThreadTest02_1[i].start();
        }
    }
}

class MyThreadTest02_1 extends Thread {
    public static int count;

    public  void method() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("name = " + Thread.currentThread().getName() + " count = " + count++);
        }

    }

    @Override
    public void run() {
        method();
    }
}
