package bridge.utils;

import java.util.Objects;

public class StringUtils {
    public static boolean isBlank(final String inputBridgeSize) {
        return Objects.isNull(inputBridgeSize) || inputBridgeSize.isEmpty();
    }
}
