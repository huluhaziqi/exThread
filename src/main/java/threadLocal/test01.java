package threadLocal;

public class test01 {
    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        if (threadLocal.get() == null){
            System.out.println("没放过值");
            threadLocal.set("嘛22222");
        }
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
    }
}
