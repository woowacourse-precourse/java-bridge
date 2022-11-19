package bridge.validation;

import java.util.List;

public class InputValidator {

    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String ALPHA_REGEX = "^[a-zA-Z]+$";

    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    private static final List<String> directions = List.of("U", "D");
    private static final List<String> retries = List.of("R", "Q");


    public static void checkBridgeSize(String bridgeSize) throws IllegalArgumentException {
        if (isNotDigit(bridgeSize)) {
            throw new IllegalArgumentException("다리 길이는 숫자만 입력할 수 있습니다.");
        }

        if (isWrongBridgeSize(Integer.valueOf(bridgeSize))) {
            throw new IllegalArgumentException("다리 길이는 3이상, 20이하의 크기만 가능합니다.");
        }
    }

    public static void checkMovingChoice(String movingChoice) throws IllegalArgumentException {
        if (isNotAlpha(movingChoice) || isWrongMoving(movingChoice)) {
            throw new IllegalArgumentException("다리 선택은 알파벳 U, D만 입력할 수 있습니다.");
        }
    }

    public static void checkRetryIntention(String retryIntention) throws IllegalArgumentException {
        if (isNotAlpha(retryIntention) || isWrongRetry(retryIntention)) {
            throw new IllegalArgumentException("게임 재시작 여부는 알파벳 R, Q만 입력할 수 있습니다.");
        }
    }

    private static boolean isNotDigit(String inputDigit) {
        return !inputDigit.matches(DIGIT_REGEX);
    }

    private static boolean isWrongBridgeSize(int bridgeSize) {
        return (bridgeSize < BRIDGE_MIN_SIZE || bridgeSize > BRIDGE_MAX_SIZE);
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