package backup;

public class waitNotifyInsertTest {
    public static void main(String[] args) {
        DbTools dbTools = new DbTools();
        for (int i = 0; i < 20; i++) {
            BackA backA = new BackA(dbTools);
            backA.start();
            BackB backB = new BackB(dbTools);
            backB.start();
        }
    }
}

class BackA extends Thread {
    private DbTools dbTools;

    public BackA(DbTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backA();
    }
}

class BackB extends Thread {
    private DbTools dbTools;

    public BackB(DbTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backB();
    }
}

class DbTools {
    private volatile boolean isPre = false;

    synchronized public void backA() {
        try {
            while (isPre == true) {
                this.wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("aaaaa");
            }
            System.out.println();
            isPre = true;
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backB() {
        try {
            while (isPre == false) {
                this.wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("bbbbb");
            }
            System.out.println();
            isPre = false;
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}