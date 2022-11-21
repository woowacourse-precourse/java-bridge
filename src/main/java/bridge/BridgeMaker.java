package bridge;

import bridge.game.Moving;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        while (bridge.size() < size) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(toLetter(number));
        }

        return bridge;
    }

    private String toLetter(int number) {
        if (number == Moving.UP.getNumber()) {
            return Moving.UP.getLetter();
        }

        return Moving.DOWN.getLetter();
    }
}
