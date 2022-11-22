package bridge;

public class Validation {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void ofBridgeSize(int size) {
        validateBridgeSizeRange(size);
    }

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리의 길이는 숫자이어야 합니다.");
        }
    }

    private static void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20)
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리의 길이는 3 이상 20 이하의 숫자이어야 합니다.");
    }

    public static void ofMoving(String input) {
        if (!input.equals("U") && !input.equals("D"))
            throw new IllegalArgumentException(ERROR_MESSAGE + "이동할 칸은 위는 U, 아래는 D로 입력해야 합니다.");
    }

    public static void ofRestart(String input) {
        if (!input.equals("R") && !input.equals("Q"))
            throw new IllegalArgumentException(ERROR_MESSAGE + "재시도는 R, 종료는 Q로 입력해야 합니다.");
    }
}
