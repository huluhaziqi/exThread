package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        MyThread01[] myThread01s = new MyThread01[10];
        String[] dateStringArray = new String[]{"2000-01-01","2001-01-02","2000-01-03","2000-01-04"
                ,"2000-01-08","2003-01-10","2000-01-08","2003-01-10"
                ,"2000-01-08","2003-01-10"};
        for(int i = 0 ;i < 10; i++){
            myThread01s[i] = new MyThread01(dateStringArray[i]);
            myThread01s[i].start();
        }
    }
}

class MyThread01 extends Thread {
    private SimpleDateFormat simpleDateFormat;

    private String dateString;

    public MyThread01(String dateString) {
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date date = DateTools.parse("yyyy-MM-dd", dateString);
            String newDateString = DateTools.format("yyyy-MM-dd", date);
            if (!newDateString.equals(dateString)) {
                System.out.println(dateString + " " + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
