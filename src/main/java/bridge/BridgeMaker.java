package bridge;

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

    /**
     * 랜덤하게 생성되는 숫자를 이용하여 다리를 의미하는 리스트를 생성 및 반환하는 메소드
     *
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomBridgeNum = bridgeNumberGenerator.generate();
            if (randomBridgeNum == 0) { bridge.add("D"); }
            if (randomBridgeNum == 1) { bridge.add("U"); }
        }
        return bridge;
    }
}
