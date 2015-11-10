package dvl.labs.util;

import java.util.Date;

/**
 * Created by iura on 11/5/15.
 */
public class TimeUtil {

    public static long getCurrentTime() {
        Date date = new Date();
        return date.getTime();
    }

}
