package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

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
