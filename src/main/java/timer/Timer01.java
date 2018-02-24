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
            System.out.println("运行时间是 ：" + new Date());
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2018-02-24 14:50:50";
        try {
            System.out.println("当前时间" + new Date());
            timer.schedule(myTask,dateFormat.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
