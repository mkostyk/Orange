import java.util.ArrayList;
import java.util.Arrays;

// Class representing a calendar.
public class Calendar {
    private final WorkingHours working_hours;
    private final Meeting[] planned_meeting;

    // Empty constructor for JSON deserialization.
    public Calendar() {
        working_hours = new WorkingHours("", "");
        planned_meeting = new Meeting[0];
    }
    
    public Calendar(WorkingHours wh, Meeting[] pm) {
        working_hours = wh;
        planned_meeting = pm;
    }

    // Flattens the calendar into a list of events.
    public ArrayList<Event> flatten() {
       ArrayList<Event> events = new ArrayList<>();

       events.add(new Event(working_hours.getStart(), 1)); // Start of workday make worker free
       events.add(new Event(working_hours.getEnd(), -1)); // End of workday make worker "busy"

       for (Meeting m: planned_meeting) {
           events.add(new Event(m.getStart(), -1)); // Start of meeting make worker busy
           events.add(new Event(m.getEnd(), 1)); // End of meeting make worker free
       }

       return events;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "working_hours=" + working_hours +
                ", planned_meetings=" + Arrays.toString(planned_meeting) +
                '}';
    }
}
