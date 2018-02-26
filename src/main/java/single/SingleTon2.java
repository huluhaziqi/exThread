package single;

public class SingleTon2 {
    private static class MyObjectHandler{
        private static SingleTon2 singleTon2 = new SingleTon2();
    }

    public SingleTon2() {
    }

    public static SingleTon2 getInstance(){
        return MyObjectHandler.singleTon2;
    }
}
