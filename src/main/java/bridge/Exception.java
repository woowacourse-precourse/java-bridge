package bridge;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Exception {
    private static final String MOVE_BRIDGE_EXCEPTION_MESSAGE = "[ERROR] 위는 U, 아래는 D로 입력해야 합니다.";
    public static final String RETRY_COMMAND = "R";
    public static final String END_COMMAND = "Q";
    private static final String RESTART_EXCEPTION_MESSAGE = "[ERROR] 재시작은 R, 종료는 Q로 입력해야 합니다.";

    public static void moveBridgeException(String moveBridgePhrase) {
        if ((!Objects.equals(moveBridgePhrase, BridgeMaker.UP_BRIDGE_PHRASE)) && (!Objects.equals(moveBridgePhrase, BridgeMaker.DOWN_BRIDGE_PHRASE))) {
            throw new NoSuchElementException(MOVE_BRIDGE_EXCEPTION_MESSAGE);
        }
    }

    public static void retryException(String command) {
        if ((!Objects.equals(command, RETRY_COMMAND))
                && (!Objects.equals(command, END_COMMAND))) {
            throw new NoSuchElementException(RESTART_EXCEPTION_MESSAGE);
        }
    }
}
