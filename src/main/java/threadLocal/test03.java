package threadLocal;

/**
 * 子线程可以继承父类线程的value
 */
public class test03 {
    private static InheritableTest inheritableTest = new InheritableTest();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            if (inheritableTest.get() == null) {
                inheritableTest.set("null_" + System.currentTimeMillis());
            }
            System.out.println(inheritableTest.get());
        }

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                if (inheritableTest.get() == null) {
                    inheritableTest.set("add _" + System.currentTimeMillis());
                }
                System.out.println(inheritableTest.get());
            }
        });
        thread.start();
    }
}


