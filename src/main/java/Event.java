// Class representing an event (start of work/end of work/start of meeting/end of meeting)
// We keep a number representing if this event makes worker free (+1) or busy (-1)
public class Event implements Comparable<Event> {
    private String hour;
    private int effect; // (+1/-1)

    public Event(String h, int eff) {
        hour = h;
        effect = eff;
    }

    public String getHour() {
        return hour;
    }

    public int getEffect() {
        return effect;
    }

    public static int minutesFromMidnight(String time) {
        if (time.equals("")) {
            return 0;
        }

        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));

        return 60 * h + m;
    }

    public int compareTo(Event other) {
        return (this.hour).compareTo(other.hour);
    }

    @Override
    public String toString() {
        return "Event{" +
                "hour='" + hour + '\'' +
                ", effect=" + effect +
                '}';
    }
}
