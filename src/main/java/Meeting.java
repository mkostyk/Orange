public class Meeting extends Interval {

    public Meeting(String s, String e) {
        super(s, e);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
