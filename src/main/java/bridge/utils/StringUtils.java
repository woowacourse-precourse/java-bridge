package bridge.utils;

import bridge.exception.UtilClassCreateException;

import java.util.Objects;

public class StringUtils {
    private StringUtils() {
        throw new UtilClassCreateException();
    }
    
    public static boolean isBlank(final String inputBridgeSize) {
        return Objects.isNull(inputBridgeSize) || inputBridgeSize.isEmpty();
    }
}
