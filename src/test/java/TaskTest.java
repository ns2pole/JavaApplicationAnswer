import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void isExpired()  throws URISyntaxException, IOException, ParseException, InterruptedException {
        Task task1 = new Task("タスク1", "2023/06/06");
        assertTrue(task1.isExpired());
        Task task2 = new Task("タスク2", "2023/05/26");
        assertTrue(task2.isExpired());
        Task task3 = new Task("タスク3", "2023/12/26");
        assertFalse(task3.isExpired());
        Task task4 = new Task("タスク4", "2023/06/07");
        assertFalse(task4.isExpired());
    }

    @Test
    void countDaysToDeadLineDate() throws ParseException{
        Task task1 = new Task("タスク1", "2023/06/10");
        assertEquals(3,task1.countToDeadLineDate());
    }

    //prac25
    @Test
    void sum() {
        int[] arr1 = {10,20,30};
        assertEquals(60, Task.sum(arr1));
        int[] arr2 = {0,10,15};
        assertEquals(25, Task.sum(arr2));
    }

}