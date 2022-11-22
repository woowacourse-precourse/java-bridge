package utils;

public class Validator {
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자로 이루어진 다리 길이를 입력해야합니다.";
    private static final String INVALID_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 다리의 길이는 3 이상 20 이하여야 합니다.";
    private static final String INVALID_MOVING_PLACE_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U 나 D 로 입력해야합니다.";
    private static final String INVALID_GAME_COMMAND_ERROR_MESSAGE = "[ERROR] 재시도 여부는 R 이나 Q 로 입력해야합니다.";

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    private static final String MATCHER = "[+-]?\\d*(\\.\\d+)?";

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    public static boolean isValidBridgeSize(String BridgeSize) {
        return isNumber(BridgeSize) && isValidSizeRange(BridgeSize);
    }

    private static boolean isNumber(String bridgeSize) {
        try {
            checkNumberOrThrowException(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    private static void checkNumberOrThrowException(String bridgeSize) {
        if (!bridgeSize.matches(MATCHER)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static boolean isValidSizeRange(String bridgeSize) {
        try {
            checkBridgeSizeOrThrowException(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    private static void checkBridgeSizeOrThrowException(String size) {
        int bridgeSize = Integer.parseInt(size);

        if (bridgeSize < MINIMUM_BRIDGE_SIZE || bridgeSize > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public static boolean isValidMovingPlace(String movingPlace) {
        try {
            checkUpDownOrThrowException(movingPlace);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    private static void checkUpDownOrThrowException(String movingPlace) {
        if (!movingPlace.equals(UP) && !movingPlace.equals(DOWN)) {
            throw new IllegalArgumentException(INVALID_MOVING_PLACE_ERROR_MESSAGE);
        }
    }

    public static boolean isValidGameCommand(String gameCommand) {
        try {
            checkRetryQuitOrThrowException(gameCommand);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    private static void checkRetryQuitOrThrowException(String gameCommand) {
        if (!gameCommand.equals(RETRY) && !gameCommand.equals(QUIT)) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR_MESSAGE);
        }
    }
}
