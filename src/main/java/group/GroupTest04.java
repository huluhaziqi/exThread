package group;

public class GroupTest04 {

    public static void main(String[] args) {
        try {
            ThreadGroup group = new ThreadGroup("我的线程组");
            for (int i = 0; i < 5; i++) {
                MyThread thread = new MyThread(group,"线程" + (i + 1));
                thread.setName("线程 " + (i + 1));
                thread.start();
            }

            Thread.sleep(5000);
            group.interrupt();
            System.out.println("调用interrupt（）");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("停止了");
        }
    }
}

class MyThread extends Thread {

    public MyThread(ThreadGroup group, String target) {
        super(group, target);
    }

    @Override
    public void run() {
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "准备开始循环");
        while (!this.isInterrupted()) {

        }
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "结束了"
        );
    }
}
