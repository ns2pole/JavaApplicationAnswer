import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void isWeekDay() throws Exception{
        assertEquals(false, DateUtil.isWeekDay("2023/05/14"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/15"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/16"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/17"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/18"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/19"));
        assertEquals(false, DateUtil.isWeekDay("2023/05/20"));
        assertEquals(false, DateUtil.isWeekDay("2023/05/21"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/22"));
        assertEquals(true, DateUtil.isWeekDay("2023/05/23"));
        assertEquals(false, DateUtil.isWeekDay("2023/05/27"));
        assertEquals(false, DateUtil.isWeekDay("2023/05/28"));
        assertThrows(ParseException.class, () -> DateUtil.isWeekDay("2023-03-01"));
        assertThrows(ParseException.class, () -> DateUtil.isWeekDay("アイウエオ"));
        assertThrows(ParseException.class, () -> DateUtil.isWeekDay("2023-03-1"));
        assertThrows(ParseException.class, () -> DateUtil.isWeekDay("2023-3-01"));
    }

    @Test
    void isSaturdayOrSunday() throws Exception{
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/14"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/15"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/16"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/17"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/18"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/19"));
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/20"));
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/21"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/22"));
        assertEquals(false, DateUtil.isSaturdayOrSunday("2023/05/23"));
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/27"));
        assertEquals(true, DateUtil.isSaturdayOrSunday("2023/05/28"));
    }

    @Test
    void getNationalHoliday() throws Exception {
        String[] expected = {
                "2023/01/01",
                "2023/01/02",
                "2023/01/09",
                "2023/02/11",
                "2023/02/23",
                "2023/03/21",
                "2023/04/29",
                "2023/05/03",
                "2023/05/04",
                "2023/05/05",
                "2023/07/17",
                "2023/08/11",
                "2023/09/18",
                "2023/09/23",
                "2023/10/09",
                "2023/11/03",
                "2023/11/23"
        };
        System.out.println("actual");
        String[] actual = DateUtil.getNationalHoliday(2023);
        System.out.println(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void isNationalHoliday() throws Exception {
        assertEquals(true, DateUtil.isNationalHoliday("2023/01/01"));
        assertEquals(true, DateUtil.isNationalHoliday("2023/01/02"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/03"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/04"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/05"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/06"));
        assertEquals(false, DateUtil.isNationalHoliday("2023/01/07"));
    }

    @Test
    void isHoliday() throws Exception {
        assertEquals(true, DateUtil.isHoliday("2023/01/01"));
        assertEquals(true, DateUtil.isHoliday("2023/01/02"));
        assertEquals(false, DateUtil.isHoliday("2023/01/03"));
        assertEquals(false, DateUtil.isHoliday("2023/01/04"));
        assertEquals(false, DateUtil.isHoliday("2023/01/05"));
        assertEquals(false, DateUtil.isHoliday("2023/01/06"));
        assertEquals(true, DateUtil.isHoliday("2023/01/07"));
        assertEquals(true, DateUtil.isHoliday("2023/01/08"));
        assertEquals(true, DateUtil.isHoliday("2023/01/09"));
        assertEquals(true, DateUtil.isHoliday("2022/01/08"));
        assertEquals(true, DateUtil.isHoliday("2022/01/09"));
        assertEquals(true, DateUtil.isHoliday("2022/01/10"));
        assertEquals(false, DateUtil.isHoliday("2022/01/11"));
    }

    @Test
    void validateAndParseDate() throws ParseException {
        String inputDate = "2023-05-07";
        assertThrows(ParseException.class, () -> DateUtil.validateAndParseDate(inputDate));
        String inputDate2 = "2023/05/07";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 5 - 1, 7, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), DateUtil.validateAndParseDate(inputDate2));
    }

    @Test
    void getDaysBetweenDates() throws ParseException {
        assertEquals(2, DateUtil.countDaysBetween("2023/03/04", "2023/03/06"));
        assertEquals(2, DateUtil.countDaysBetween("2023/03/30", "2023/04/01"));
        assertEquals(5, DateUtil.countDaysBetween("2023/03/30", "2023/04/04"));
        assertEquals(31, DateUtil.countDaysBetween("2023/03/30", "2023/04/30"));
    }

    @Test
    void getDaysStrBetween() throws ParseException {
        String[] actual1 = DateUtil.getDaysStrBetween("2023/05/11", "2023/05/21");
        String[] expected1 = {
                "2023/05/11",
                "2023/05/12",
                "2023/05/13",
                "2023/05/14",
                "2023/05/15",
                "2023/05/16",
                "2023/05/17",
                "2023/05/18",
                "2023/05/19",
                "2023/05/20",
                "2023/05/21"
        };
        assertArrayEquals(expected1, actual1);

        String[] actual2 = DateUtil.getDaysStrBetween("2022/12/27", "2023/01/04");
        String[] expected2 = {
                "2022/12/27",
                "2022/12/28",
                "2022/12/29",
                "2022/12/30",
                "2022/12/31",
                "2023/01/01",
                "2023/01/02",
                "2023/01/03",
                "2023/01/04"
        };
        assertArrayEquals(expected2, actual2);
    }

    //Taskクラスとの兼ね合いで、toの日付は含めないように仕様変更
    @Test
    void countWorkingDays() throws URISyntaxException, IOException, InterruptedException, ParseException {
        assertEquals(1, DateUtil.countWorkingDays("2023/05/11", "2023/05/12"));
        assertEquals(3, DateUtil.countWorkingDays("2023/05/11", "2023/05/16"));
        assertEquals(7, DateUtil.countWorkingDays("2023/05/11", "2023/05/20"));
        assertEquals(7, DateUtil.countWorkingDays("2023/05/11", "2023/05/21"));
        assertEquals(0, DateUtil.countWorkingDays("2023/05/20", "2023/05/21"));
        assertEquals(0, DateUtil.countWorkingDays("2023/05/21", "2023/05/21"));
        assertEquals(0, DateUtil.countWorkingDays("2023/01/01", "2023/01/03"));
        assertEquals(1, DateUtil.countWorkingDays("2023/01/06", "2023/01/09"));
        assertEquals(1, DateUtil.countWorkingDays("2023/01/06", "2023/01/10"));
        assertEquals(19, DateUtil.countWorkingDays("2023/01/01", "2023/01/31"));
        assertEquals(5, DateUtil.countWorkingDays("2022/12/27", "2023/01/04"));
    }

    @Test
    void getNextWorkingDayOf() throws Exception {
        assertEquals("2023/06/01", DateUtil.getNextWorkingDayOf("2023/05/31"));
        assertEquals("2023/06/05", DateUtil.getNextWorkingDayOf("2023/06/02"));
        assertEquals("2023/01/03", DateUtil.getNextWorkingDayOf("2023/01/01"));
        assertEquals("2023/01/10", DateUtil.getNextWorkingDayOf("2023/01/06"));
    }
}