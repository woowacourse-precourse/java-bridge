package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private static final String BLOCK_OF_UPSIDE = "U";
    private static final String BLOCK_OF_DOWNSIDE = "D";
    private static final int NUMBER_OF_UPSIDE = 1;
    private static final int NUMBER_OF_DOWNSIDE = 0;
    private static final int STARTING_INDEX = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int i = STARTING_INDEX; i < size; i++) {
            generateRandomUpDown(bridge);
        }
        return bridge;
    }

    public void generateRandomUpDown(List<String> bridge) {
        int upDownNumber = bridgeNumberGenerator.generate();

        if (upDownNumber == NUMBER_OF_DOWNSIDE) {
            bridge.add(BLOCK_OF_DOWNSIDE);
        }
        if (upDownNumber == NUMBER_OF_UPSIDE) {
            bridge.add(BLOCK_OF_UPSIDE);
        }
    }
}
