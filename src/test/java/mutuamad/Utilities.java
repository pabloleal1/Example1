package mutuamad;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utilities {

    /**
     * Method sleep
     * @param milis
     */
    public static void sleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch(Exception e) {}
    }

    /**
     * Method getActualDate
     * @return The actual date
     */
    public static Date getActualDate() {
        GregorianCalendar gc = new GregorianCalendar();
        Date date = gc.getTime();
        return date;
    }

    /**
     * Method getDay
     * @param date
     * @return Return the day of today
     */
    public static int getDay (Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

}
