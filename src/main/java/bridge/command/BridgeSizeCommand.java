package bridge.command;

import java.util.regex.Pattern;

/**
 * bridge 사아즈를 입력받는 커맨드 객체입니다
 */
public class BridgeSizeCommand {
    private static final Pattern NUMBERS = Pattern.compile("^\\d+$");
    private static final String BRIDGE_NULL_MESSAGE = "입력에 null 이 포함되었습니다";
    private static final String PARSE_ERROR_MESSAGE = "숫자의 범위가 벗어났습니다";
    private static final String NOT_NUMBER_MESSAGE = "숫자로만 이루어지지 않았습니다";
    private final int bridgeSize;

    public BridgeSizeCommand(final String input) {
        validate(input);
        try {
            bridgeSize = Integer.parseInt(input);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_ERROR_MESSAGE);
        }
    }

    private void validate(final String input) {
        if (isNull(input)) {
            throw new IllegalArgumentException(BRIDGE_NULL_MESSAGE);
        }
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    private boolean isNull(final String input) {
        return input == null;
    }

    private boolean isNotNumber(final String input) {
        return !NUMBERS.matcher(input).matches();
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
