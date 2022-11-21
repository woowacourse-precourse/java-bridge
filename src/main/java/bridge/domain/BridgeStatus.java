package bridge.domain;

import java.util.Arrays;

import static bridge.domain.Constants.*;
import static bridge.domain.exception.ErrorMessage.*;

public enum BridgeStatus {

    UP_O(UP, O),
    UP_X(UP, X),
    DOWN_O(DOWN, O),
    DOWN_X(DOWN, X);

    private final String arrow;
    private final String status;

    BridgeStatus(String arrow, String status) {
        this.arrow = arrow;
        this.status = status;
    }

    public String getArrow() {
        return arrow;
    }

    public String getStatus() {
        return status;
    }

    public static BridgeStatus valueOfArrowAndMark(String arrow, String mark) {
        return Arrays.stream(values())
                .filter(value -> value.arrow.equals(arrow) && value.status.equals(mark))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(ERROR_BRIDGE_STATUS));
    }
}
