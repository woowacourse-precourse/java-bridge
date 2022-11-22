package bridge.util;

import java.util.Objects;

public class Validation {
    private static final String INVAILED_LENGTH = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INVAILED_MOVING = "[ERROR] U 또는 D로 입력해야 합니다.";
    private static final String INVAILED_COMMAND = "[ERROR] R 또는 Q를 입력하셔야 합니다.";
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    public static void bridgeLengthValidation(int length) {
        if (length > MAX_LENGTH || length < MIN_LENGTH) {
            throw new IllegalArgumentException(INVAILED_LENGTH);
        }
    }

    public static void movedValidation(String move) {
        if (!Objects.equals(move, Position.UP.getInitial()) && !Objects.equals(move, Position.DOWN.getInitial())) {
            throw new IllegalArgumentException(INVAILED_MOVING);
        }
    }

    public static void restartValidation(String move) {
        if (!Objects.equals(move, Command.RESTART.getCommand()) && !Objects.equals(move,
                Command.QUIT.getCommand())) {
            throw new IllegalArgumentException(INVAILED_COMMAND);
        }
    }

}