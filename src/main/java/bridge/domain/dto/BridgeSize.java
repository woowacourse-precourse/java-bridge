package bridge.dto;

import bridge.util.StringUtils;

import java.util.regex.Pattern;

public class BridgeSize {
    private static final String BRIDGE_SIZE_PATTERN = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^[2]{1}[0]{1}$";    // 3 ~ 20
    private static final String RANGE_EXCEPTION_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String BLANK_EXCEPTION_MESSAGE = "Null 또는 Empty 를 입력할 수 없습니다.";

    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {
        this(parseBridgeSize(bridgeSize));
    }

    public BridgeSize(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    private static int parseBridgeSize(final String bridgeSize) {
        validate(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private static void validate(final String bridgeSize) {
        validateBlank(bridgeSize);
        validateRange(bridgeSize);
    }

    private static void validateRange(final String bridgeSize) {
        if (!Pattern.matches(BRIDGE_SIZE_PATTERN, bridgeSize)) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateBlank(final String bridgeSize) {
        if (StringUtils.isBlank(bridgeSize)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
