package bridge.service.dto.request;

import java.util.regex.Pattern;

public class BridgeSizeRequestDto {
    private static final Pattern ONLY_NUMBER_REGEX = Pattern.compile("^[0-9]*$");
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String NOT_ONLY_NUMBER = "[ERROR] 숫자만 입력이 가능합니다.";
    private static final String NOT_MIN_SIZE = "[ERROR] 다리의 길이는 3이상이어야 합니다.";
    private static final String NOT_MAX_SIZE = "[ERROR] 다리의 길이는 20이하이어야 합니다.";

    private final int bridgeSize;

    public BridgeSizeRequestDto(String size) {
        int bridgeSize = validateOnlyNumber(size);
        validateMinSize(bridgeSize);
        validateMaxSize(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    private int validateOnlyNumber(String input) {
        if (!ONLY_NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(NOT_ONLY_NUMBER);
        }
        return Integer.parseInt(input);
    }

    private void validateMinSize(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException(NOT_MIN_SIZE);
        }
    }

    private void validateMaxSize(int size) {
        if (size > MAX_SIZE) {
            throw new IllegalArgumentException(NOT_MAX_SIZE);
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
