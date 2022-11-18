package bridge.util;

import bridge.domain.Movement;

public class ErrorMessage {
    private static final String ERROR = "[ERROR] ";

    public static final String IS_NOT_NUMBER = ERROR + "다리 길이는 숫자여야 합니다.";
    public static final String IS_NOT_RANGE_SIZE =
            ERROR + "다리 길이의 범위는 " + BridgeConstatns.SIZE_MINIMUM + " ~ " + BridgeConstatns.SIZE_MAXIMUM
                    + " 사이여야 합니다.";

    public static final String IS_NOT_MOVEMENT =
            ERROR + "이동할 칸은 " + Movement.U.name() + " 또는 " + Movement.D.name() + " 값이어야 합니다.";

    private ErrorMessage() {

    }
}
