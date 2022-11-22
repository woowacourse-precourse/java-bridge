package bridge;

import bridge.command.MovingCommand;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int generateValue = bridgeNumberGenerator.generate();
            if (generateValue == 0) bridge.add(MovingCommand.DownStairs.get());
            if (generateValue == 1) bridge.add(MovingCommand.UpStairs.get());
        }
        return bridge;
    }
}
