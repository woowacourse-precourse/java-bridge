package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    public static final int BRIDGE_DOWN_RANDOM_NUMBER = 0;
    public static final int BRIDGE_UP_RANDOM_NUMBER = 1;
    public static final String BRIDGE_DOWN_MARK = "D";
    public static final String BRIDGE_UP_MARK = "U";
    public static final int INIT_SIZE_INDEX = 0;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int sizeIndex = INIT_SIZE_INDEX; sizeIndex < size; sizeIndex++) {
            int number = bridgeNumberGenerator.generate();
            chageNumberToMark(bridge, number);
        }
        return bridge;
    }

    private static void chageNumberToMark(List<String> bridge, int number) {
        if (number == BRIDGE_DOWN_RANDOM_NUMBER) {
            bridge.add(BRIDGE_DOWN_MARK);
        }
        if (number == BRIDGE_UP_RANDOM_NUMBER) {
            bridge.add(BRIDGE_UP_MARK);
        }
    }
}
