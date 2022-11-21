package bridge.domain;

import java.util.Arrays;

import static bridge.domain.Constants.*;
import static bridge.domain.exception.ErrorMessage.*;

public enum BridgeStatus {

    UP_O(UP, O),
    UP_X(UP, X),
    DOWN_O(DOWN, O),
    DOWN_X(DOWN, X);

    private final String moving;
    private final String status;

    BridgeStatus(String moving, String status) {
        this.moving = moving;
        this.status = status;
    }

    public String getMoving() {
        return moving;
    }

    public String getStatus() {
        return status;
    }

    public static BridgeStatus valueOfArrowAndMark(String arrow, String mark) {
        return Arrays.stream(values())
                .filter(value -> value.moving.equals(arrow) && value.status.equals(mark))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(ERROR_BRIDGE_STATUS));
    }
}
