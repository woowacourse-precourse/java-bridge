package bridge.domain;

import static bridge.domain.BridgeCellType.DOWN;
import static bridge.domain.BridgeCellType.UP;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;
    private static final String INVALID_BRIDGE_SIZE_MESSAGE = "다리 길이는 3이상 20이하의 정수여야 합니다.";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        validateBridgeSize(size);
        for (int i = 0; i < size; i++) {
            bridge.add(convertRandomNumberToBridgeCellType(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String convertRandomNumberToBridgeCellType(int randomNumber) {
        if (randomNumber == 1) {
            return UP.getCellType();
        }
        return DOWN.getCellType();
    }

    private void validateBridgeSize(int input) {
        if (input < MIN_BRIDGE_LENGTH || input > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_MESSAGE);
        }
    }
}
