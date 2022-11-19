package bridge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private List<String> bridge;
    private BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String randomNumber = String.valueOf(bridgeNumberGenerator.generate());
            bridge.add(randomNumber);
        }
        makeUpDownBridge();
        return bridge;
    }

    public void makeUpDownBridge() {
        for (int index = 0; index < bridge.size(); index++) {
            String blockOfBridge = bridge.get(index);
            if (blockOfBridge.equals("0")) {
                bridge.set(index, "D");
            }
            if (blockOfBridge.equals("1")) {
                bridge.set(index, "U");
            }
        }
    }

    public StringBuilder makeInitialBridge() {
        String bridgeFrame = "[ ]";
        StringBuilder initialBridge = new StringBuilder(bridgeFrame);
        return initialBridge;
    }
}