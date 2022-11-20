package bridge.domain;

import java.util.List;

public class Bridge {
    private static final int MINIMUM_RANGE = 3;
    private static final int MAXIMUM_RANGE = 20;
    private static final String INVALID_LENGTH_RANGE_MESSAGE = "[ERROR] 다리 길이는 " + MINIMUM_RANGE + "이상 " + MAXIMUM_RANGE + "이하의 숫자를 입력해주세요.";

    private final List<String> bridgeAnswers;

    public Bridge(List<String> bridgeAnswers) {
        validateLengthRange(bridgeAnswers.size());
        this.bridgeAnswers = bridgeAnswers;
    }

    private void validateLengthRange(int length) {
        if (length >= MINIMUM_RANGE && length <= MAXIMUM_RANGE) {
            return;
        }
        throw new IllegalArgumentException(INVALID_LENGTH_RANGE_MESSAGE);
    }

    public boolean isAnswer(MoveDirection direction, int index) {
        return direction.isEqualTo(bridgeAnswers.get(index));
    }

    public int getBridgeSize() {
        return bridgeAnswers.size();
    }
}
