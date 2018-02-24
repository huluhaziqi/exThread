package timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer02 {
    private static Timer timer = new Timer();

    static class MyTask02 extends TimerTask {
        @Override
        public void run() {
            System.out.println("A运行时间是 ： " + new Date());
            try {
                Thread.sleep(2000);
                //将自己从timeTask队列中清除
                this.cancel();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class MyTask03 extends TimerTask {
        @Override
        public void run() {
            System.out.println("B运行时间是 ： " + new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask02 myTask = new MyTask02();
        MyTask03 myTask2 = new MyTask03();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2018-02-24 15:16:00";
        try {
            System.out.println("当前时间" + new Date());
            timer.schedule(myTask,dateFormat.parse(dateString),2000);
            timer.schedule(myTask2,dateFormat.parse(dateString),2000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
