package bridge.domain.util;

import java.util.Objects;

public class ValidationUtil {
    private static final String INVAILED_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INVAILED_MOVE = "[ERROR] U 또는 D로 입력해야 합니다.";
    private static final String INVAILED_GAME_COMMAND = "[ERROR] R 또는 Q를 입력하셔야 합니다.";
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    public static void bridgeSizeValidation(int bridgeSize) {
        if (bridgeSize > MAX_SIZE || bridgeSize < MIN_SIZE) {
            throw new IllegalArgumentException(INVAILED_SIZE);
        }
    }

    public static void movedValidation(String move) {
        if (!Objects.equals(move, Position.UP.getInitial()) && !Objects.equals(move, Position.DOWN.getInitial())) {
            throw new IllegalArgumentException(INVAILED_MOVE);
        }
    }

    public static void restartValidation(String move) {
        if (!Objects.equals(move, GameCommand.RESTART.getCommand()) && !Objects.equals(move,
                GameCommand.QUIT.getCommand())) {
            throw new IllegalArgumentException(INVAILED_GAME_COMMAND);
        }
    }

}
