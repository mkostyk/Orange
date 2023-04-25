// Class representing some time interval.
public class Interval {
    protected final String start;
    protected final String end;

    public Interval(String s, String e) {
        start = s;
        end = e;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
