package bridge.utils;

public class Validation {
    public static int validateBridgeSize(String bridgeSize) {
        int bridgeSizeNumber = validateNumber(bridgeSize);
        return validateSize(bridgeSizeNumber);
    }

    private static int validateSize(int bridgeSizeNumber) {
        if (bridgeSizeNumber < 3 || bridgeSizeNumber > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하여야 합니다.");
        }
        return bridgeSizeNumber;
    }

    private static int validateNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자여야 합니다.");
        }
        return Integer.parseInt(bridgeSize);
    }

    public static String validateMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 다리 이동은 U나 D 중 한가지만 입력해주세요.");
        }
        return moving;
    }

    public static String validateRestartInput(String restartAnswer) {
        if (!(restartAnswer.equals("R") || restartAnswer.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 재시작은 R, 종료는 Q를 입력해주세요.");
        }
        return restartAnswer;
    }
}
