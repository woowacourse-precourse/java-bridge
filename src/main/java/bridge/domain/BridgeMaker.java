package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.util.BridgeType;

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
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(toString(number));
        }
        return bridge;
    }

    /**
     * @param number 다리 위인지 아래인지를 나타내는 숫자
     * @return 1이면 "U", 0이면 "D"로 표현해야 한다.
     */
    public String toString(int number) {
        BridgeType bridge = BridgeType.valueOfNumber(number);
        return bridge.getInitial();
    }
}
