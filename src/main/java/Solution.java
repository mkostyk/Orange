import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.google.gson.Gson;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO
        String meeting_duration = "00:45";
        int duration = Event.minutesFromMidnight(meeting_duration);

        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new FileReader("./src/main/java/calendar1.json"));
        Calendar calendar1 = gson.fromJson(br, Calendar.class);

        br = new BufferedReader(new FileReader("./src/main/java/calendar2.json"));
        Calendar calendar2 = gson.fromJson(br, Calendar.class);

        ArrayList<Event> events1 = calendar1.flatten();
        ArrayList<Event> events2 = calendar2.flatten();

        events1.addAll(events2);
        Collections.sort(events1);

        // We start with both workers being "busy" as they're not in their working hours.
        int counter = -2;
        String time = "";
        ArrayList<Interval> result = new ArrayList<>();

        for (Event e: events1) {
            if (counter == 0 && !time.equals(e.getHour())) {
                // End of free time
                int diff = Event.minutesFromMidnight(e.getHour()) - Event.minutesFromMidnight(time);
                if (diff >= duration) {
                    result.add(new Interval(time, e.getHour()));
                }
            }

            counter += e.getEffect();
            time = e.getHour();
        }

        System.out.println(result);
    }
}
