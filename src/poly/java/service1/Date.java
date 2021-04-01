package poly.java.service1;

public class Date {
    private int day;
    private Time time;

    public Date(int day, int hour, int minute, int second) {
        if (day < 1 || day > 30) {
            throw new IllegalArgumentException("Incorrect Time");
        }
        this.day = day;
        time = new Time(hour, minute, second);
    }

    public int getDay() { return day; }

    public int getHour() { return time.hour; }

    public int getMinute() { return time.minute; }

    public int getSecond() { return time.second; }

    private static class Time {
        int hour;
        int minute;
        int second;

        private Time(int h, int m, int s) {
            if (h >= 0 && h <= 23
                    && m >= 0 && m <= 60
                    && s >= 0 && s <= 60) {
                this.hour = h;
                this.minute = m;
                this.second = s;
            }
            else {
                throw new IllegalArgumentException("Incorrect Time");
            }
        }
    }

}
