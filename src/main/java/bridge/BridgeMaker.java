package bridge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String randomNumber = String.valueOf(bridgeNumberGenerator.generate());
            bridge.add(randomNumber);
        }
        bridge = makeUpDownBridge(bridge);
        return bridge;
    }

    public List<String> makeUpDownBridge(List<String> bridge) {
        for (int index = 0; index < bridge.size(); index++) {
            String blockOfBridge = bridge.get(index);
            if (blockOfBridge == "0") {
                bridge.set(index, "D");
            }
            if (blockOfBridge == "1") {
                bridge.set(index, "U");
            }
        }
        return bridge;
    }

    public StringBuilder makeInitialBridge() {
        String bridgeFrame = "[   ]";
        StringBuilder initialBridge = new StringBuilder(bridgeFrame);
        return initialBridge;
    }
}