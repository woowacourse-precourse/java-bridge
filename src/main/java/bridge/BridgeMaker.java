package bridge;

import constant.Values.BridgeCase;
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
        Checker checker = new Checker();
        size = checker.checkNegative(size);
        List<String> bridge = new ArrayList<>();
        generateValue(bridge, size);
        return bridge;
    }

    private List<String> generateValue(List<String> bridge, int size) {
        if (size <= 0) {
            return bridge;
        }
        if (bridgeNumberGenerator.generate() == 0) {
            return generateValue(bridge, size, BridgeCase.NEGATIVE);
        }
        return generateValue(bridge, size, BridgeCase.POSITIVE);
    }

    private List<String> generateValue(List<String> bridge, int size, BridgeCase bridgeCase) {
        bridge.add(bridgeCase.getValue());
        size -= 1;
        return generateValue(bridge, size);
    }

}
