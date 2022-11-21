package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.constants.MovableSpace.UP_SPACE;
import static bridge.util.constants.MovableSpace.DOWN_SPACE;
import static bridge.util.constants.BridgeConstant.MIN_BRIDGE_SIZE;
import static bridge.util.constants.BridgeConstant.MAX_BRIDGE_SIZE;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * makeBridge 내부만 수정 가능
 */
public class BridgeMaker {

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
        List<String> bridge = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            addMovableSpace(bridge, bridgeNumber);
        }
        return bridge;
    }

    public void validateSize(int size) {
        if (size < MIN_BRIDGE_SIZE.getValue() || MAX_BRIDGE_SIZE.getValue() < size) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 ~ 20사이여야 합니다");
        }
    }

    public void addMovableSpace(List<String> bridge, int bridgeNumber) {
        validateBridgeNumber(bridgeNumber);
        if (bridgeNumber == 1) {
            bridge.add(UP_SPACE.getValue());
            return;
        }
        bridge.add(DOWN_SPACE.getValue());
    }

    public void validateBridgeNumber(int bridgeNumber) {
        if (bridgeNumber < 0 || 1 < bridgeNumber) {
            throw new IllegalStateException("[ERROR] 생성된 다리번호가 유효하지 않습니다");
        }
    }
}
