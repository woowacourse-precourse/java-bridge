package bridge.view;

import bridge.constants.Command;
import bridge.constants.Move;

import java.util.Objects;

public class Verification {

    private final String ERROR_MESSAGE_SIZE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String ERROR_MOVE_UD = "U, D 두개 중에 하나 선택 해야 합니다.";
    private final String ERROR_RETRY_RQ = "R, Q 두개 중에 하나 선택 해야 합니다.";

    public void verifyBridgeSize(int size) {
        final int MIN_NUMBER = 3;
        final int MAX_NUMBER = 20;

        if (!(MIN_NUMBER <= size && size <= MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SIZE);
        }
    }

    public void verifyUorD(String move) {
        if (!(Objects.equals(move, Move.UP_BRIDGE.getValue()) || Objects.equals(move, Move.DOWN_BRIDGE.getValue()))) {
            throw new IllegalArgumentException(ERROR_MOVE_UD);
        }
    }

    public void verifyQorR(String retry) {
        if (!(Objects.equals(retry, Command.RETRY.getCommandGame()) || Objects.equals(retry, Command.QUIT.getCommandGame()))) {
            throw new IllegalArgumentException(ERROR_RETRY_RQ);
        }
    }
}
