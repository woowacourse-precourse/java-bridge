package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final String SIZE_TYPE_ERROR = "다리의 길이는 정수로 입력해야 합니다.";
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
        for (int number = 0; number < size; number++) {
            addBridgeNumber(bridge);
        }
        return bridge;
    }

    private void addBridgeNumber(List<String> bridge) {
        int randomNumber = bridgeNumberGenerator.generate();
        addNumbers(bridge, randomNumber);
    }

    private void addNumbers(List<String> bridge, int randomNumber) {
        if (randomNumber == 0) {
            bridge.add("U");
        }
        if (randomNumber == 1) {
            bridge.add("D");
        }
    }
}
