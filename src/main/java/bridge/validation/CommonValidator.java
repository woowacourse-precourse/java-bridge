package bridge.validation;

public class CommonValidator {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private static final String ERROR = "[ERROR] ";
    private static final String MOVING_ERROR = ERROR + UP + " 또는 " + DOWN + "를 입력해주세요.";
    private static final String COMMAND_ERROR = ERROR + RESTART + " 또는 " + QUIT + "를 입력해주세요.";


    public static void checkCommand(String command) {
        if (isWrongCommand(command)) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
    }

    public static void checkMoving(String moving) {
        if (isWrongMoving(moving)) {
            throw new IllegalArgumentException(MOVING_ERROR);
        }
    }

    private static boolean isWrongCommand(String command) {
        return !(command.equals(RESTART) || command.equals(QUIT));
    }

    private static boolean isWrongMoving(String moving) {
        return !(moving.equals(UP) || moving.equals(DOWN));
    }

    private CommonValidator() {
    }
}
