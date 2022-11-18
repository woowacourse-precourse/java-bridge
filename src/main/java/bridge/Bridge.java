package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final String INVALID_LENGTH_RANGE_MESSAGE = "[ERROR] 다리 길이는 3이상 20이하의 숫자를 입력해주세요.";
    private final int length;
    private final List<String> bridgeAnswers;

    public Bridge(int length) {
        validateLengthRange(length);
        this.length = length;
        bridgeAnswers = new ArrayList<>();
    }

    private void validateLengthRange(int length) {
        if (length >= 3 && length <= 20) {
            return;
        }
        throw new IllegalArgumentException(INVALID_LENGTH_RANGE_MESSAGE);
    }
}
