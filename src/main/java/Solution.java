import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;

public class Solution {
    // Main meeting planner function
    public static String[][] meetingPlanner(Calendar calendar1, Calendar calendar2, String meeting_duration) {
        int duration = Event.minutesFromMidnight(meeting_duration);

        ArrayList<Event> events1 = calendar1.flatten();
        ArrayList<Event> events2 = calendar2.flatten();

        events1.addAll(events2);
        // We sort all events by their time, so we can easily keep track of how many
        // workers are busy at any given time.
        Collections.sort(events1);

        // We start with both workers being "busy" as they're not in their working hours.
        int busy_counter = -2;
        String time = "";
        ArrayList<String[]> result = new ArrayList<>(); // Arraylist so it is easier to add elements

        for (Event e: events1) {
            if (busy_counter == 0 && !time.equals(e.getHour())) {
                // End of free time
                int diff = Event.minutesFromMidnight(e.getHour()) - Event.minutesFromMidnight(time);
                if (diff >= duration) {
                    result.add(new String[] {time, e.getHour()}.clone());
                }
            }

            busy_counter += e.getEffect();
            time = e.getHour();
        }

        return result.toArray(new String[0][0]);
    }

    // Meeting planner function that takes JSON files as input
    public static String[][] meetingPlannerFromJson(String file1, String file2, String meeting_duration) {
        Gson gson = new Gson();
        Calendar calendar1 = new Calendar(), calendar2 = new Calendar();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            calendar1 = gson.fromJson(br, Calendar.class);

            br = new BufferedReader(new FileReader(file2));
            calendar2 = gson.fromJson(br, Calendar.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return meetingPlanner(calendar1, calendar2, meeting_duration);
    }
}
