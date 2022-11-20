package bridge;

import bridge.type.MovingType;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int index = 1; index <= size; index++) {
            bridge.add(pickPositionByRandomNumber());
        }
        return bridge;
    }

    private String pickPositionByRandomNumber() {
        if (bridgeNumberGenerator.generate() == 1) {
            return MovingType.UP.getKey();
        }
        return MovingType.DOWN.getKey();
    }
}
