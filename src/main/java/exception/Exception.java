package exception;

import java.util.List;

public class Exception {

    public static boolean bridgeLengthValidation(List<String> bridge) {
        if (!(3 <= bridge.size() && bridge.size() <= 20)) {
            return false;
        }
        return true;
    }
}
