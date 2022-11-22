package bridge.exception;

public class BridgeGameException {

    private static final String ERROR_INVALID_BRIDGE_INDEX = "잘못된 인덱스 접근 입니다. size : %d, 접근한 인덱스 : %d%s";

    public static void invalidBridgeIndex(final int size, final int index) {
        throw new IndexOutOfBoundsException(
                String.format(ERROR_INVALID_BRIDGE_INDEX, size, index, System.lineSeparator()));
    }
}
