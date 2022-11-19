package bridge;

import bridge.constant.Constants;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final List<String> INDEX_TO_DIRECTION = List.of(Constants.DOWN, Constants.UP);

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
        for (int count = 0; count < size; count++) {
            String road = chooseCrossableRoad();
            bridge.add(road);
        }
        return bridge;
    }

    private String chooseCrossableRoad() {
        int index = bridgeNumberGenerator.generate();
        return INDEX_TO_DIRECTION.get(index);
    }
}
