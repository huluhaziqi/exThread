package group;

public class GroupTest02 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()
                + "  所属的线程组名为："
                + Thread.currentThread().getThreadGroup().getName()
                + " "
                + Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup group = new ThreadGroup("新的组");
        System.out.println(Thread.currentThread().getName() + "所属的线程组名为 ：" +
                Thread.currentThread().getThreadGroup().getName() + " " +
                Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup[] threadGroups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadGroups);
        for (int i = 0; i < threadGroups.length; i++) {
            System.out.println("线程组名字：" + threadGroups[i].getName());
        }
    }
}
