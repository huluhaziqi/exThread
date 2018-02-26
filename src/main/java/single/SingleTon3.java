package single;

public class SingleTon3 {
    // 利用static代码块实现单例模式
    private static SingleTon3 instance = null;

    public SingleTon3() {
    }

    static {
        instance = new SingleTon3();
    }

    public static SingleTon3 getInstance() {
        return instance;
    }
}
