package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.utils.ErrorMessages.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int LOWER_INCLUSIVE = 0;
    private static final int UPPER_INCLUSIVE = 1;
    private static final String UP_SIDE_SHAPE = "U";
    private static final String DOWN_SIDE_SHAPE = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> makeBridgeShape())
                .collect(Collectors.toList());
    }

    private String makeBridgeShape() {
        int bridgeNumber = generateBridgeRandomNumber();
        return getBridgeShape(bridgeNumber);
    }

    private int generateBridgeRandomNumber() {
        int randomNumber = bridgeNumberGenerator.generate();
        validateBridgeRandomNumber(randomNumber);
        return randomNumber;
    }

    private String getBridgeShape(int bridgeNumber) {
        if (bridgeNumber == 0) {
            return DOWN_SIDE_SHAPE;
        }
        return UP_SIDE_SHAPE;
    }

    private void validateBridgeRandomNumber(int shape) {
        if (!(shape == LOWER_INCLUSIVE || shape == UPPER_INCLUSIVE)) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_NUMBER);
        }
    }
}