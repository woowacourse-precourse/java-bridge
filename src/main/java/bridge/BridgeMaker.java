package bridge;

import bridge.util.SafeSide;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        final List<String> answerBridge = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            updateBridge(answerBridge);
        }
        return answerBridge;
    }

    private void updateBridge(List<String> bridge) {
        bridge.add(pickSafeSide());
    }

    private String pickSafeSide() {
        final int number = bridgeNumberGenerator.generate();
        return SafeSide.chooseUpOrDown(number);
    }
}
