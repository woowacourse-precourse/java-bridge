package bridge.exception;

public class BridgeException {

    private static final String ERROR_INVALID_BRIDGE_SIZE = "다리 길이가 3 이상 20 이하의 다리만 만들 수 있습니다.";
    private static final String ERROR_INVALID_BRIDGE_INDEX = "잘못된 인덱스 접근 입니다. size : %d, 접근한 인덱스 : %d%s";
    private static final String ERROR_IS_NOT_NUMBER = "숫자를 입력해 주세요.";
    private static final String ERROR_SIZE_ZERO = "적어도 한 글자 이상 입력 해야 합니다.(공백은 무시)";

    public static void invalidBridgeSize() {
        throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
    }

    public static void invalidBridgeIndex(final int size, final int index) {
        throw new IndexOutOfBoundsException(
                String.format(ERROR_INVALID_BRIDGE_INDEX, size, index, System.lineSeparator()));
    }

    public static void isNotNumber() {
        throw new NumberFormatException(ERROR_IS_NOT_NUMBER);
    }

    public static void inputSizeZero() {
        throw new IllegalArgumentException(ERROR_SIZE_ZERO);
    }
}
