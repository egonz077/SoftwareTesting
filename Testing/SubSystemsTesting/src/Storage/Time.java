package Storage;


public class Time {

    public int frHr;
    public int frMn;
    public int toHr;
    public int toMn;
    public String days;

    public Time(String from, String to, String days) {
        this.frHr = new Integer(from.substring(0,2));
        this.frMn = new Integer(from.substring(3,5));
        this.toHr = new Integer(to.substring(0,2));
        this.toMn = new Integer(to.substring(3,5));
        this.days = days;
    }

    public Time(int from_hour, int from_minutes, int to_hour, int to_minutes, String days) {
        this.frHr = from_hour;
        this.frMn = from_minutes;
        this.toHr = to_hour;
        this.toMn = to_minutes;
        this.days = days;
    }

    public String toString() {
        return frHr + ":" + frMn + "-" + toHr + ":" + toMn;
    }

    public String getFromTime() {
        return String.valueOf(frHr)+String.valueOf(frMn);
    }

    public String getToTime() {
        return String.valueOf(toHr)+String.valueOf(toMn);
    }

}

