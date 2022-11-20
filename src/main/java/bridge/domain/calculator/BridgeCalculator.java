package bridge.domain.calculator;

import java.util.List;

public class BridgeCalculator {
    private final List<String> crossableBridge;

    public BridgeCalculator(List<String> crossableBridge) {
        this.crossableBridge = crossableBridge;
    }

    public boolean isCrossable(int gameRound, String playerInput) {
        return crossableBridge.get(gameRound).equals(playerInput);
    }
}
