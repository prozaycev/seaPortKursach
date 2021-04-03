package poly.java.service1;

import poly.java.service1.ship.Ship;

public class Date implements Comparable<Date> {
    public static final int SECOND_IN_MONTH = 30 * 24 * 60;
    private final int day;
    private final Time time;

    public Date(int day, int hour, int minute) {
        if (day < 1 || day > 30) {
            throw new IllegalArgumentException("Incorrect Time");
        }
        this.day = day;
        time = new Time(hour, minute);
    }

    public Date(int minutes) {
        if (minutes < 0 || minutes > SECOND_IN_MONTH) {
            throw new IllegalArgumentException("Incorrect Time");
        }
        time = new Time(0, 0);
        time.minute = minutes % 60;
        minutes /= 60;
        time.hour = minutes % 24;

        day = minutes / 24 + 1;
    }

    private static class Time {
        int hour;
        int minute;

        private Time(int h, int m) {
            if (h >= 0 && h < 24 && m >= 0 && m < 60) {
                this.hour = h;
                this.minute = m;
            } else {
                throw new IllegalArgumentException("Incorrect Time");
            }
        }
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return time.hour;
    }

    public int getMinute() {
        return time.minute;
    }

    public int getMinuteFromFirstDayInMonthToArrival() {
        return time.minute + time.hour * 60 + day * 60 * 24;
    }

    @Override
    public String toString() {
        return getDay() + ":" + getHour() + ":" + getMinute();
    }

    public int compareTo(Date date) {
        return Integer.compare(getMinuteFromFirstDayInMonthToArrival(), date.getMinuteFromFirstDayInMonthToArrival());
    }
}
