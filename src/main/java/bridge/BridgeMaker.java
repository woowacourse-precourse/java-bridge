package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> randomBridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            String position = findPosition(randomNumber);
            randomBridge.add(position);
        }
        return randomBridge;
    }

    private String findPosition(int randomNumber) {
        State state = State.of(randomNumber);
        String position = state.getPosition();
        return position;
    }
}
