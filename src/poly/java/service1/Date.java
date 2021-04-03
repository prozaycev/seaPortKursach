package poly.java.service1;

public class Date implements Comparable<Date> {
    private static final int DAY_IN_MONTH = 30;
    private static final int HOUR_IN_DAY = 24;
    private static final int MINUTES_IN_HOUR = 60;
    public static final int MINUTES_IN_MONTH = DAY_IN_MONTH * HOUR_IN_DAY * MINUTES_IN_HOUR; // НОРМ ЧТО ОНО public?

    private final int day;
    private final Time time;

    public Date(int day, int hour, int minute) {
        if (day < 1 || day > DAY_IN_MONTH) {
            throw new IllegalArgumentException("Incorrect Time");
        }
        this.day = day;
        time = new Time(hour, minute);
    }

    public Date(int minutes) {
        if (minutes < 0 || minutes > MINUTES_IN_MONTH) {
            throw new IllegalArgumentException("Incorrect Time");
        }
        time = new Time(0, 0);
        time.minute = minutes % MINUTES_IN_HOUR;
        minutes /= MINUTES_IN_HOUR;
        time.hour = minutes % HOUR_IN_DAY;

        day = (minutes / HOUR_IN_DAY) + 1;
    }

    private static class Time {
        int hour;
        int minute;

        private Time(int h, int m) {
            if (h < 0 || h >= HOUR_IN_DAY ||
                    m < 0 || m >= MINUTES_IN_HOUR) {
                throw new IllegalArgumentException("Incorrect Time");
            }
            this.hour = h;
            this.minute = m;
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
        return time.minute + time.hour * MINUTES_IN_HOUR + day * MINUTES_IN_HOUR * HOUR_IN_DAY;
    }

    @Override
    public String toString() {
        return getDay() + ":" + getHour() + ":" + getMinute();
    } // написать форматирование dd:hh:mm

    public int compareTo(Date date) {
        return Integer.compare(getMinuteFromFirstDayInMonthToArrival(), date.getMinuteFromFirstDayInMonthToArrival());
    }
}
