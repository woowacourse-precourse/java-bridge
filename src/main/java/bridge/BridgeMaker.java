package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int ZERO = 0;
    private static final int SIZE_LOWER_LIMIT = 3;
    private static final int SIZE_UPPER_LIMIT = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String INVALID_SIZE_ERROR = "3에서 20사이의 수를 입력해주세요.";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        return generateRandomNumbers(size);
    }

    private String upOrDown(int randomNumber) {
        if (randomNumber == ZERO) {
            return DOWN;
        }
        return UP;
    }

    private void validateSize(int size) {
        if (size < SIZE_LOWER_LIMIT || size > SIZE_UPPER_LIMIT) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR);
        }
    }

    private List<String> generateRandomNumbers(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            bridge.add(upOrDown(randomNumber));
        }
        return bridge;
    }
}
