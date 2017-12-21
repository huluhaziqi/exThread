package synchronize;

public class SynchronizedTest13 {
    /**
     * 静态内部类的synchronized方法与class锁是同步，与其他不同对象锁异步
     * @param args
     */
    public static void main(String[] args) {
        final MyThreadTest13_1.InnerClass1 innerClass1 = new MyThreadTest13_1.InnerClass1();
        final MyThreadTest13_1.InnerClass2 innerClass2 = new MyThreadTest13_1.InnerClass2();
        Thread thread = new Thread() {
            @Override
            public void run() {
                innerClass1.method1(innerClass2);
            }
        };
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                innerClass1.methon2();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                innerClass2.method1();
            }
        };
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class MyThreadTest13_1 extends Thread {
    static class InnerClass1 {
        public void method1(InnerClass2 class2) {
            synchronized (class2) {
                try {
                    System.out.println("开始");
                    for (int i = 0; i < 10; i++) {
                        System.out.println("i = " + i);
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void methon2() {
            try {
                System.out.println("开始method2");
                for (int i = 0; i < 10; i++) {
                    System.out.println("k = " + i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class InnerClass2 {
        public synchronized void method1() {
            try {
                System.out.println("innerClass2 method1");
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(200);
                    System.out.println("j = " + i);
                }
                System.out.println("end");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

class MyThreadTest13_2 extends Thread {

}
