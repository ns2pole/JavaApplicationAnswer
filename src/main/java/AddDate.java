import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AddDate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("日付を入力してください (yyyy/MM/dd): ");
        String inputDate = scanner.next(); // コマンドラインから日付を読み取ります。
        System.out.print("加算する日数を整数で入力してください: ");
        int daysToAdd = Integer.parseInt(scanner.next()); // コマンドラインから日付を読み取ります。
        try {
            Date date = DateUtil.validateAndParseDate(inputDate);
            Date newDate = DateUtil.addDaysToDate(date, daysToAdd);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            System.out.println("新しい日付: " + sdf.format(newDate));
        } catch (ParseException e) {
            System.err.println("エラー: 日付の形式が正しくありません。");
        }
       scanner.close();

    }

    



}