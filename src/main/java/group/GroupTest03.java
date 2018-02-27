package group;

public class GroupTest03 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent().getName());

    }
}
