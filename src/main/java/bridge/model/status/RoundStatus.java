package bridge.model.status;

import bridge.util.ExceptionMessage;
import java.util.Arrays;

public enum RoundStatus {

    ROUND_SUCCESS("O", true),
    ROUND_FAIL("X", false),
    ROUND_NONE(" ", false);

    private final String display;
    private final boolean isSuccess;

    RoundStatus(String display, boolean isRoundSuccess) {
        this.display = display;
        this.isSuccess = isRoundSuccess;
    }

    public static RoundStatus from(boolean isSuccess) {
        return Arrays.stream(RoundStatus.values())
                .filter(element -> element.isSuccess == isSuccess)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_ROUND_STATUS.getMessage()));
    }

    public String getDisplay() {
        return display;
    }

    public boolean isRoundSuccess() {
        return isSuccess;
    }

    public boolean isRoundFail() {
        return !isSuccess;
    }

}
