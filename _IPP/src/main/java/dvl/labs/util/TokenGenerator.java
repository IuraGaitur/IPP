package dvl.labs.util;

import java.security.SecureRandom;

/**
 * Created by iura on 11/9/15.
 */
public class TokenGenerator {

    public static String getNewToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes.toString();

    }
}
