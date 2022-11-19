package bridge;

import bridge.input.Command;

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
            bridge.add(toCommand(number));
        }
        return bridge;
    }

    private String toCommand(int number) {
        if (number == Command.UP.getNumber()) {
            return Command.UP.getLetter();
        }
        return Command.DOWN.getLetter();
    }
}
