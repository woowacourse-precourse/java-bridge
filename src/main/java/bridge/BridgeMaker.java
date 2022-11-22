package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int RANDOM_LOWER = 0;
    private static final int RANDOM_UPPER = 1;

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
        for (int i = 0; i < size; ++i) {
            makeBridgeShape(bridge);
        }
        return bridge;
    }

    /**
     * 다리 모양 생성 로직
     * @param bridge 다리 모양 리스트
     */
    private void makeBridgeShape(List<String> bridge) {
        int generate = bridgeNumberGenerator.generate();
        if (generate == RANDOM_UPPER) {
            bridge.add("U");
            return;
        }
        if (generate == RANDOM_LOWER) {
            bridge.add("D");
            return;
        }
    }
}
