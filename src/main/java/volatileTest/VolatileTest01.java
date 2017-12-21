package volatileTest;

public class VolatileTest01 {

    public static void main(String[] args) {
        try {
            PrintString2 printString = new PrintString2();
            printString.start();
            Thread.sleep(1000);
            System.out.println("need to be stop " + Thread.currentThread().getName());
            printString.setContinue(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class PrintString2 extends Thread {

    private boolean isContinue = true;

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    @Override
    public void run() {
        try {
            System.out.println("begin");
            while (isContinue) {
                System.out.println("name = " + Thread.currentThread().getName());
                Thread.sleep(2000);
            }
            System.out.println("end be stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintString implements Runnable {

    private boolean isContinue = true;

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public void run() {
        printMethod();
    }

    public void printMethod() {
        try {
            System.out.println("begin");
            while (isContinue) {
                System.out.println("name = " + Thread.currentThread().getName());
                Thread.sleep(2000);
            }
            System.out.println("end be stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
