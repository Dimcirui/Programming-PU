public class Clock {
    private static final int UPPER_HOUR = 24, UPPER_MINUTE = 60;
    private int hour, minute;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > UPPER_HOUR - 1) throw new IllegalArgumentException("The hour must be between 0 and 23");
        if (m < 0 || m > UPPER_MINUTE - 1) throw new IllegalArgumentException("The minute must be between 0 and 59");

        hour = h;
        minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (!s.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d$")) {
            throw new IllegalArgumentException("The correct format must be HH:MM");
        }

        int index = s.indexOf(':');
        hour = Integer.parseInt(s.substring(0, index));
        minute = Integer.parseInt(s.substring(index + 1));
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String hh = Integer.toString(hour);
        String mm = Integer.toString(minute);

        if (hh.length() == 1) hh = "0" + hh;
        if (mm.length() == 1) mm = "0" + mm;

        return hh + ":" + mm;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        return (hour < that.hour || (hour == that.hour && minute < that.minute));
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (minute < UPPER_MINUTE - 1) minute++;
        else if (hour < UPPER_HOUR - 1) {
            hour++;
            minute = 0;
        }
        else {
            hour = 0;
            minute = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("You should add positive minutes");

        int sum = hour * UPPER_MINUTE + minute + delta;
        sum %= UPPER_HOUR * UPPER_MINUTE;
        hour = sum / UPPER_MINUTE;
        minute = sum % UPPER_MINUTE;
    }

    public static void main(String[] args) {
        Clock time1 = new Clock(23, 59);
        Clock time2 = new Clock("06:00");

        System.out.println(time1);
        time1.tic();
        System.out.println(time1);

        System.out.println(time2);
        time2.toc(12305);
        System.out.println(time2);

        System.out.println(time1.isEarlierThan(time2));
    }
}
