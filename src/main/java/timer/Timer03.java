package timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer03 {
    private static Timer timer = new Timer();
    private static Timer timer2 = new Timer();
    //如果没有延时则schedule按照开始的时间计算
    //如果延时schedule按照结束的时间计算
    //如果没有延时scheduleAtFixedRate按照上一次开始时间计算
    //如果有延时scheduleAtFixedRate按照上一次结束时间计算
    static class MyTask02 extends TimerTask {
        @Override
        public void run() {
            System.out.println("A begin 时间是 ： " + new Date());
            try {
                Thread.sleep(3000);
                System.out.println("A end 时间是 ： " + new Date());

//                将自己从timeTask队列中清除
//                this.cancel();
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
                Thread.sleep(3000);
                //清除所有
//                timer.cancel();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask02 myTask = new MyTask02();
        MyTask03 myTask2 = new MyTask03();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2018-02-24 16:29:35";
        try {
            System.out.println("当前时间" + new Date());
            timer.scheduleAtFixedRate(myTask,dateFormat.parse(dateString),2000);
//            timer2.scheduleAtFixedRate(myTask2,dateFormat.parse(dateString),2000);
//            timer.cancel();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}