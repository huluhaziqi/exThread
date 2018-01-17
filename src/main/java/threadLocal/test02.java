package threadLocal;

public class test02 {

    private static ThreadLocal local = new ThreadLocal();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (local.get() == null) {
                    local.set("thread a " + System.currentTimeMillis());
                }
                System.out.println(local.get());
            }
        }
        );
        thread.start();

        if(local.get() == null){
            local.set("main " + System.currentTimeMillis() + "_" + "222");
        }
        for(int i = 0; i < 20; i++){
            System.out.println(local.get());
        }
    }
}


