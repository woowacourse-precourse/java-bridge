package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * 필드 변경 불가능
 * 매서드 시그니쳐, 반환타입 변경 불가
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
        List<String> bridge = new ArrayList<>();
        for (int blockIndex = 0; blockIndex < size; blockIndex++) {
            makeBridgeBlock(bridge);
        }

        return bridge;
    }

    private void makeBridgeBlock(List<String> bridge) {
        int blockNumber = bridgeNumberGenerator.generate();
        if (blockNumber == 1) {
            bridge.add("U");
            return;
        }
        bridge.add("D");
    }
}
