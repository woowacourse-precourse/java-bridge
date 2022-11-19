package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.utils.ErrorMessages.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int LOWER_INCLUSIVE = 0;
    private static final int UPPER_INCLUSIVE = 1;
    private static final int SIZE_MIN_RANGE = 3;
    private static final int SIZE_MAX_RANGE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
    }

    private int generateBridgeRandomNumber() {
        int randomNumber = bridgeNumberGenerator.generate();
        validateBridgeRandomNumber(randomNumber);
        return randomNumber;
    }

    private void validateBridgeRandomNumber(int shape) {
        if (!(shape == LOWER_INCLUSIVE || shape == UPPER_INCLUSIVE)) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_NUMBER);
        }
    }
}