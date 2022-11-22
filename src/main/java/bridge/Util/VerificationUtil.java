package bridge.Util;

import bridge.Domain.Key;

public class VerificationUtil {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String SIZE_NOT_NUMERIC = "[ERROR] 다리 길이는 숫자여야 합니다.";
    private static final String SIZE_NOT_IN_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String UNACCEPTABLE_MOVING = "[ERROR] 이동할 칸은 U 또는 D로 입력할 수 있습니다.";
    private static final String UNACCEPTABLE_COMMAND = "[ERROR] 재시작 여부는 R 또는 Q로 입력할 수 있습니다.";

    private VerificationUtil() {}

    public static int verifyNumeric(String size) {
        int numericSize;

        try {
            numericSize = Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SIZE_NOT_NUMERIC);
        }
        return numericSize;
    }

    public static void verifyBridgeSize(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE)
            throw new IllegalArgumentException(SIZE_NOT_IN_RANGE);
    }

    public static void verifyMoving(String moving) {
        if (!moving.equals(Key.UP) && !moving.equals(Key.DOWN))
            throw new IllegalArgumentException(UNACCEPTABLE_MOVING);
    }

    public static void verifyGameCommand(String command) {
        if (!command.equals(Key.RETRY) && !command.equals(Key.QUIT))
            throw new IllegalArgumentException(UNACCEPTABLE_COMMAND);
    }
}
