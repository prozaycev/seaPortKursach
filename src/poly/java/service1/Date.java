package poly.java.service1;

public class Date {
    public static final int SECOND_IN_MONTH = 30*24*60;
    private int day;
    private Time time;

    public Date(int day, int hour, int minute) {
        if (day < 1 || day > 30) {
            throw new IllegalArgumentException("Incorrect Time");
        }
        this.day = day;
        time = new Time(hour, minute);
    }

    public Date(int seconds) {
        if (seconds < 0 || seconds > SECOND_IN_MONTH) {
            throw new IllegalArgumentException("Incorrect Time");
        }
        time = new Time(0, 0);
        time.minute = seconds % 60;
        seconds /= 60;
        time.hour = seconds % 24;

        day = seconds / 24 + 1;
    }

    private static class Time {
        int hour;
        int minute;

        private Time(int h, int m) {
            if (h >= 0 && h < 24 && m >= 0 && m < 60) {
                this.hour = h;
                this.minute = m;
            }
            else {
                throw new IllegalArgumentException("Incorrect Time");
            }
        }
    }

    public int getDay() { return day; }

    public int getHour() { return time.hour; }

    public int getMinute() { return time.minute; }

    @Override
    public String toString() {
        return getDay() + ":" + getHour() + ":" + getMinute();
    }
}
