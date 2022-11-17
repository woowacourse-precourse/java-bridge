package exception;

import java.util.List;

public class Exception {

    public static boolean bridgeLengthValidation(int bridgeSize) {
        if (!(3 <= bridgeSize && bridgeSize <= 20)) {
            return false;
        }
        return true;
    }
}
