import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTests {
    @Test
    public void basic_test() {
        Meeting[] meetings_one = new Meeting[] {
                new Meeting("09:00", "10:30"),
                new Meeting("12:00", "13:00"),
                new Meeting("16:00", "18:00")
        };

        WorkingHours working_hours_one = new WorkingHours("09:00", "19:55");

        Meeting[] meetings_two = new Meeting[] {
                new Meeting("10:00", "11:30"),
                new Meeting("12:30", "14:30"),
                new Meeting("14:30", "15:00"),
                new Meeting("16:00", "17:00")
        };

        WorkingHours working_hours_two = new WorkingHours("10:00", "18:30");

        Calendar calendar_one = new Calendar(working_hours_one, meetings_one);
        Calendar calendar_two = new Calendar(working_hours_two, meetings_two);

        String[][] expected = new String[][] {
                new String[]{"11:30", "12:00"},
                new String[]{"15:00", "16:00"},
                new String[]{"18:00", "18:30"}
        };

        String[][] actual = Solution.meetingPlanner(calendar_one, calendar_two, "00:30");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void custom_test_1() {
        Meeting[] meetings_one = new Meeting[] {
            new Meeting("09:00", "10:30"),
            new Meeting("12:00", "13:00"),
            new Meeting("16:00", "18:00")
        };

        WorkingHours working_hours_one = new WorkingHours("09:00", "20:00");

        Meeting[] meetings_two = new Meeting[] {
                new Meeting("10:00", "11:30"),
                new Meeting("12:00", "14:00"),
                new Meeting("16:30", "18:00")
        };

        WorkingHours working_hours_two = new WorkingHours("10:00", "18:00");

        Calendar calendar_one = new Calendar(working_hours_one, meetings_one);
        Calendar calendar_two = new Calendar(working_hours_two, meetings_two);

        String[][] expected = new String[][] {
            new String[]{"14:00", "16:00"},
        };

        String[][] actual = Solution.meetingPlanner(calendar_one, calendar_two, "00:45");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void custom_test_2() {
        Meeting[] meetings_one = new Meeting[] {
                new Meeting("14:00", "16:30"),
                new Meeting("17:20", "19:00")
        };

        WorkingHours working_hours_one = new WorkingHours("14:00", "23:00");

        Meeting[] meetings_two = new Meeting[] {
                new Meeting("10:00", "11:30"),
                new Meeting("12:00", "14:00"),
                new Meeting("17:30", "18:00")
        };

        WorkingHours working_hours_two = new WorkingHours("10:00", "19:40");

        Calendar calendar_one = new Calendar(working_hours_one, meetings_one);
        Calendar calendar_two = new Calendar(working_hours_two, meetings_two);

        String[][] expected = new String[][] {
                new String[]{"16:30", "17:20"},
        };

        String[][] actual = Solution.meetingPlanner(calendar_one, calendar_two, "00:45");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_json() {
        String[][] expected = new String[][] {
                new String[]{"11:30", "12:00"},
                new String[]{"15:00", "16:00"},
                new String[]{"18:00", "18:30"}
        };

        String[][] actual = Solution.meetingPlannerFromJson(
                "./src/test/java/calendar1.json",
                "./src/test/java/calendar2.json",
                "00:30"
        );

        assertArrayEquals(expected, actual);
    }
}
