// Just Interval class, but with different name to improve code readability.
public class WorkingHours extends Interval {

    public WorkingHours(String s, String e) {
        super(s, e);
    }

    @Override
    public String toString() {
        return "WorkingHours{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
