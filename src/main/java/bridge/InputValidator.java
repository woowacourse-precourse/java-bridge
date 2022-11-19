package bridge;

public class InputValidator {
    private static final String NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    private static final String NOT_IN_RANGE = "[ERROR] 3 이상 20 이하의 숫자를 입력해주세요.";
    private static final String NOT_BRIDGE = "[ERROR] U(위) 또는 D(아래) 를 입력해주세요.";
    private static final String NOT_COMMAND = "[ERROR] R(재시작) 또는 Q(종료) 를 입력해주세요.";
    private static String UP_BRIDGE = "U";
    private static String DOWN_BRIDGE = "D";
    private static String RETRY_GAME = "R";
    private static String END_GAME = "Q";

    public static void inputBridgeSizeValidate(String bridgeSize) {
        checkNumber(bridgeSize);
        checkSizeInRange(bridgeSize);
    }

    public static void inputMovingValidate(String moving) {
        checkCorrectMoving(moving);
    }

    public static void inputGameCommandValidate(String command) {
        checkCorrectCommand(command);
    }

    private static void checkCorrectCommand(String command) {
        if(!(RETRY_GAME.equals(command) || END_GAME.equals(command))) {
            throw new IllegalArgumentException(NOT_COMMAND);
        }
    }

    private static void checkCorrectMoving(String moving) {
        if(!(UP_BRIDGE.equals(moving) || DOWN_BRIDGE.equals(moving))) {
            throw new IllegalArgumentException(NOT_BRIDGE);
        }
    }

    private static void checkNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private static void checkSizeInRange(String bridgeSize) {
        int size = Integer.parseInt(bridgeSize);
        if (size < 3 || 20 < size) {
            throw new IllegalArgumentException(NOT_IN_RANGE);
        }
    }
}
