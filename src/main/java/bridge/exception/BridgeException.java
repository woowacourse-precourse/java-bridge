package bridge.exception;

public class BridgeException {

    private static final String ERROR_INVALID_BRIDGE_SIZE = "다리의 길이는 3 이상 20 이하 이어야 합니다.";

    public static void invalidBridgeSize() {
        throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
    }
}
