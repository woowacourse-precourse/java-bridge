package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.GameKeyboard.DOWN;
import static bridge.constant.GameKeyboard.UP;

public class BridgeMaker {

    public static final int BRIDGE_DOWN_RANDOM_NUMBER = 0;
    public static final int BRIDGE_UP_RANDOM_NUMBER = 1;
    public static final int INIT_SIZE_INDEX = 0;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int sizeIndex = INIT_SIZE_INDEX; sizeIndex < size; sizeIndex++) {
            int number = bridgeNumberGenerator.generate();
            changeNumberToMark(bridge, number);
        }
        return bridge;
    }

    private static void changeNumberToMark(List<String> bridge, int number) {
        if (isSameDownBridge(number)) {
            bridge.add(DOWN.letter());
        }
        if (isSameUpBridge(number)) {
            bridge.add(UP.letter());
        }
    }

    private static boolean isSameUpBridge(int number) {
        return number == BridgeMaker.BRIDGE_UP_RANDOM_NUMBER;
    }

    private static boolean isSameDownBridge(int number) {
        return number == BridgeMaker.BRIDGE_DOWN_RANDOM_NUMBER;
    }
}
