package bridge;

import java.util.ArrayList;
import java.util.List;
import util.ErrorMessage;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int MIN_BRIDGE_SIZE=3;
    private static final int MAX_BRIDGE_SIZE=20;

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
        for (int space = 1; space <= size; space++) {
            makeOneStairs(bridge);
        }
        return bridge;
    }

    private void makeOneStairs(List<String> bridge) {
        int generateNum = bridgeNumberGenerator.generate();
        bridge.add(BridgeDirect.numToDirection(generateNum));
    }

    public static void validateBridgeSize(int bridgeSize){
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_BRIDGE_SIZE);
        }
    }
}
