package bridge;

import java.util.List;

public class Bridge {
    private static final String INVALID_LENGTH_RANGE_MESSAGE = "[ERROR] 다리 길이는 3이상 20이하의 숫자를 입력해주세요.";

    private final List<String> bridgeAnswers;

    public Bridge(List<String> bridgeAnswers) {
        validateLengthRange(bridgeAnswers.size());
        this.bridgeAnswers = bridgeAnswers;
    }

    private void validateLengthRange(int length) {
        if (length >= 3 && length <= 20) {
            return;
        }
        throw new IllegalArgumentException(INVALID_LENGTH_RANGE_MESSAGE);
    }

    public List<String> getBridgeAnswers() {
        return bridgeAnswers;
    }
}
