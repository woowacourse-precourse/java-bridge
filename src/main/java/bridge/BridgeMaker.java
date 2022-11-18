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
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> firstBridge = new ArrayList<>();
        makeFirstBridge(size, firstBridge);
        return firstBridge;
    }

    private void makeFirstBridge(int size, List<String> firstBridge) {
        for (int i = 0; i < size; i++) {
            int number = this.bridgeNumberGenerator.generate();
            String result = "D";
            if (number == 1) {
                result = "U";
            }
            firstBridge.add(result);
        }
    }

    public List<String> makeSecondBridge(List<String> firstBridge) {
        List<String> secondBridge = new ArrayList<>();
        for (int i = 0; i < firstBridge.size(); i++) {
            String result = "D";
            if (firstBridge.get(i).equals("D")) {
                result = "U";
            }
            secondBridge.add(result);
        }
        return secondBridge;
    }
}
