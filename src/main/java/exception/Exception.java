package exception;

import bridge.Command;

public class Exception {

    private static final String ERROR = "[ERROR]";
    private static final String NUMBER = "[+-]?\\d*(\\.\\d+)?";

    public static boolean bridgeLengthValidation(String bridgeSize) {
        if (!bridgeSize.matches(NUMBER) || !(3 <= Integer.parseInt(bridgeSize) && Integer.parseInt(bridgeSize) <= 20)) {
            throw new IllegalArgumentException(ERROR + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return true;
    }

    public static boolean readMoveValidation(String move) {
        if (!(move.equals(Command.UP.useCommand()) || move.equals(Command.DOWN.useCommand()))) {
            throw new IllegalArgumentException(ERROR + " U 또는 D 를 입력해 주세요.");
        }
        return true;
    }

    public static boolean readGameCommandValidation(String command) {
        if (!(command.equals(Command.RETRY.useCommand()) || command.equals(Command.QUIT.useCommand()))) {
            throw new IllegalArgumentException(ERROR + " R 또는 Q 를 입력해 주세요.");
        }
        return true;
    }
}
