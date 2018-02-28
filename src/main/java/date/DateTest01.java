package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray = new String[]{"2000-01-01","2001-01-02","2000-01-03","2000-01-04"
                                    ,"2000-01-08","2003-01-10","2000-01-08","2003-01-10"
                ,"2000-01-08","2003-01-10"};
        MyThread[] myThreads = new MyThread[10];
        for(int i = 0; i < 10; i++){
            myThreads[i] = new MyThread(dateFormat,dateStringArray[i]);
        }
        for(int i = 0; i < 10; i++){
            myThreads[i].start();

        }
    }
}
class MyThread extends Thread{
    private SimpleDateFormat dateFormat;
    private String dateString;

    public MyThread(SimpleDateFormat dateFormat, String dateString) {
        this.dateFormat = dateFormat;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date date = dateFormat.parse(dateString);
            String newDateString = dateFormat.format(date).toString();
            if(!newDateString.equals(dateString)){
                System.out.println(dateString + " " + newDateString + " ");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}