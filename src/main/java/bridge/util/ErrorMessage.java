package bridge.util;

import bridge.domain.BridgeMovement;
import bridge.domain.GameCommand;

public class ErrorMessage {
    private static final String ERROR = "[ERROR] ";
    public static final String IS_NOT_NUMBER = ERROR + "다리 길이는 숫자여야 합니다.";
    public static final String IS_NOT_RANGE_SIZE =
            ERROR + "다리 길이의 범위는 " + BridgeSize.MINIMUM.getSize() + "부터 " + BridgeSize.MAXIMUM.getSize()
                    + " 사이의 숫자여야 합니다.";
    public static final String IS_NOT_MOVEMENT =
            ERROR + "이동할 칸은 " + BridgeMovement.UP.getMove() + " 또는 " + BridgeMovement.DOWN.getMove() + " 값이어야 합니다.";
    public static final String IS_NOT_COMMAND_VALUE =
            ERROR + "게임 재시작/종료 여부는 " + GameCommand.RETRY.getCode() + " 또는 " + GameCommand.QUIT.getCode() + " 값이어야 합니다.";

    private ErrorMessage() {

    }
}
