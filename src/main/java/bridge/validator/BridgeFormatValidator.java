package bridge.validator;

import java.util.List;

public class BridgeFormatValidator {

    public static final String UP = "U";
    public static final String DOWN = "D";

    private static final String BRIDGE_FORMAT_ERROR_MESSAGE = "[ERROR] 다리는 위, 아래 두 칸만으로 이루어져 있습니다.";

    public static void validate(List<String> bridge) {
        if (bridge.stream()
                .anyMatch(element -> !element.equals(UP) && !element.equals(DOWN))) {
            throw new IllegalArgumentException(BRIDGE_FORMAT_ERROR_MESSAGE);
        }
    }
}
