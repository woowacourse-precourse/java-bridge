package bridge.domain;

public class BridgeSize {

    private static final String IS_NOT_NUMBERS = "숫자만 입력해 주세요.";
    private static final String NOT_VALID_RANGE_OF_BRIDGE_SIZE = "다리의 길이는 3 이상 20 이하여야 합니다.";

    private final int bridgeSize;

    public BridgeSize(final String inputValue) {
        validateThisIsNumber(inputValue);

        int bridgeSize = Integer.parseInt(inputValue);
        validateBridgeSize(bridgeSize);

        this.bridgeSize = bridgeSize;
    }

    boolean isMoreThan(final int position) {
        return position < bridgeSize;
    }

    public int bridgeSize() {
        return bridgeSize;
    }

    private void validateThisIsNumber(final String inputValue) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!inputValue.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException(IS_NOT_NUMBERS);
        }
    }

    private void validateBridgeSize(final int size) {
        final int MIN_SIZE = 3;
        final int MAX_SIZE = 20;
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException(NOT_VALID_RANGE_OF_BRIDGE_SIZE);
        }
    }
}
