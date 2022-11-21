package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String BRIDGE_SIZE_IS_OUT_OF_RANGE = "[ERROR] 다리 길이가 범위 밖입니다.";
    private static final String NUMBER_IS_NOT_LOWER_UPPER_NUMBER = "[ERROR] 입력값이 0 또는 1이 아닙니다.";
    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;
    private static final String LOWER_BRIDGE = "D";
    private static final String UPPER_BRIDGE = "U";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSizeRange(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(drawBridge(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private void validateSizeRange(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_IS_OUT_OF_RANGE);
        }
    }

    private String drawBridge(int randomNumber) {
        validateNumber(randomNumber);
        if (randomNumber == RANDOM_LOWER_INCLUSIVE) {
            return LOWER_BRIDGE;
        }
        if (randomNumber == RANDOM_UPPER_INCLUSIVE) {
            return UPPER_BRIDGE;
        }
        return null;
    }

    private void validateNumber(int randomNumber) {
        if (randomNumber != RANDOM_LOWER_INCLUSIVE && randomNumber != RANDOM_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(NUMBER_IS_NOT_LOWER_UPPER_NUMBER);
        }
    }
}
