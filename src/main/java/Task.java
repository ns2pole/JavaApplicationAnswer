import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;


public class Task {
    String name;
    String deadLineDate;
    int actualMinuteTime;



    public Task(String name, String deadLineDate) {
        this.name = name;
        this.deadLineDate = deadLineDate;
        this.actualMinuteTime = 0;
    }

    public boolean isExpired() throws URISyntaxException, IOException, InterruptedException, ParseException{
        if(this.countToDeadLineDate() < 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean onDeadLine() throws URISyntaxException, IOException, InterruptedException, ParseException{
        if(this.countToDeadLineDate() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int countToDeadLineDate() throws ParseException {
        Calendar todayC = Calendar.getInstance();
        if(todayC.getTime().after(DateUtil.validateAndParseDate(this.deadLineDate))) {
            return -1 * DateUtil.countWorkingDays(this.deadLineDate, DateUtil.toYYYYMMDD(todayC));
        } else {
            return DateUtil.countWorkingDays(DateUtil.toYYYYMMDD(todayC), this.deadLineDate);
        }
    }

    public static int sum(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }


    private int getActualMinuteTime() {
        return this.actualMinuteTime;
    }


    public static int getTotalActualTime(Task[] tasks) {
        return Arrays
                .stream(tasks)
                .mapToInt(Task::getActualMinuteTime)
                .sum();
    }


}