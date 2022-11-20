package bridge.models;

import bridge.utils.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    // TODO bridgeNumberGenerator 단위 테스트 구현 어떻게? - 테스트 어려운 부분 분리하기
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(BridgeDirection.getDirection(bridgeNumberGenerator.generate()).getCapital());
        }
        return bridge;
    }
}
