package bridge.domain.bridgeInfo;

import bridge.BridgeMaker;
import java.util.List;

public class Length {

    private static final int MINIMUM_BRIDGE_LENGTH = 3;
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;
    private static final String BRIDGE_BLANK_ERROR = "다리의 길이는 비어있을 수 없습니다.";
    private static final String BRIDGE_TYPE_ERROR = "다리의 길이에 문자가 포함될 수 없습니다.";
    private static final String BRIDGE_RANGE_ERROR = "다리의 길이는 3 이상 20 이하의 숫자여야합니다.";
    private final int length;

    public Length(String length) {
        validate(length);
        this.length = Integer.parseInt(length);
    }

    private void validate(String answer) {
        checkNotBlank(answer);
        checkTypeValid(answer);
        checkRangeValid(answer);
    }

    public List<String> makeBridgeNumbers(BridgeMaker bridgeMaker) {
        return bridgeMaker.makeBridge(length);
    }

    public boolean isSameLength(int length) {
        return this.length == length;
    }

    private void checkNotBlank(String answer) {
        boolean isBlank = answer.isBlank();
        if (isBlank) {
            throw new IllegalArgumentException(BRIDGE_BLANK_ERROR);
        }
    }

    private void checkTypeValid(String answer) {
        boolean isTypeValid = answer.chars().allMatch(Character::isDigit);
        if (!isTypeValid) {
            throw new IllegalArgumentException(BRIDGE_TYPE_ERROR);
        }
    }

    private void checkRangeValid(String answer) {
        int size = Integer.parseInt(answer);
        boolean isRangeValid = size >= MINIMUM_BRIDGE_LENGTH && size <= MAXIMUM_BRIDGE_LENGTH;
        if (!isRangeValid) {
            throw new IllegalArgumentException(BRIDGE_RANGE_ERROR);
        }
    }
}
