package bridge.validation;

import bridge.util.Constant;

import java.util.List;

public class InputValidator {

    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String ALPHA_REGEX = "^[a-zA-Z]+$";

    private static final String BRIDGE_LENGTH_FORMAT_ERROR_MESSAGE = "다리 길이는 숫자만 입력할 수 있습니다.";
    private static final String BRIDGE_LENGTH_RANGE_ERROR_MESSAGE= "다리 길이는 3이상, 20이하의 크기만 가능합니다.";
    private static final String DIRECTION_CHOICE_ERROR_MESSAGE = "다리 선택은 알파벳 U, D만 입력할 수 있습니다.";
    private static final String GAME_RETRY_CHOICE_ERROR_MESSAGE = "게임 재시작 여부는 알파벳 R, Q만 입력할 수 있습니다.";

    private static final List<String> directions = List.of("U", "D");
    private static final List<String> retries = List.of("R", "Q");


    public static void checkBridgeSize(String bridgeSize) throws IllegalArgumentException {
        if (isNotDigit(bridgeSize)) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_FORMAT_ERROR_MESSAGE);
        }

        if (isWrongBridgeSize(Integer.valueOf(bridgeSize))) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_RANGE_ERROR_MESSAGE);
        }
    }

    public static void checkMovingChoice(String movingChoice) throws IllegalArgumentException {
        if (isNotAlpha(movingChoice) || isWrongMoving(movingChoice)) {
            throw new IllegalArgumentException(DIRECTION_CHOICE_ERROR_MESSAGE);
        }
    }

    public static void checkRetryIntention(String retryIntention) throws IllegalArgumentException {
        if (isNotAlpha(retryIntention) || isWrongRetry(retryIntention)) {
            throw new IllegalArgumentException(GAME_RETRY_CHOICE_ERROR_MESSAGE);
        }
    }

    private static boolean isNotDigit(String inputDigit) {
        return !inputDigit.matches(DIGIT_REGEX);
    }

    private static boolean isWrongBridgeSize(int bridgeSize) {
        return (bridgeSize < Constant.BRIDGE_MIN_SIZE || bridgeSize > Constant.BRIDGE_MAX_SIZE);
    }

    private static boolean isNotAlpha(String inputAlpha) {
        return !inputAlpha.matches(ALPHA_REGEX);
    }

    private static boolean isWrongMoving(String direction) {
        return !directions.contains(direction);
    }

    private static boolean isWrongRetry(String retryIntention) {
        return !retries.contains(retryIntention);
    }

}