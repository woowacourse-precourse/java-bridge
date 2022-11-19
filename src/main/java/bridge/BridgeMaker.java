package bridge;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR;

import bridge.constant.Direction;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        isValidateSize(size);
        return initializeBridge(size);
    }

    private void isValidateSize(int size) {
        if (!(size >= MIN_BRIDGE_SIZE && size <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR.toString());
        }
    }

    private List<String> initializeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridge.add(Direction.getDirection(bridgeNumber).toString());
        }
        return bridge;
    }
}
