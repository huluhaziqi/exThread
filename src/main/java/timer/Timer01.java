package timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer01 {
    private static Timer timer = new Timer();

    static class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("task1运行时间是 ：" + new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class MyTask2 extends TimerTask {
        @Override
        public void run() {
            System.out.println("task2运行时间是 ：" + new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //timeTask是按照队列的顺序被执行的，所以最终执行的时间可能跟设置的不一样，需要等待
        MyTask myTask = new MyTask();
        MyTask2 myTask2 = new MyTask2();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2018-02-24 15:00:15";
        String dateString2 = "2018-02-24 15:00:16";
        try {
            System.out.println("当前时间" + new Date());
            timer.schedule(myTask,dateFormat.parse(dateString));
            timer.schedule(myTask2,dateFormat.parse(dateString2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
