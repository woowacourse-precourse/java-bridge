package bridge;

import static bridge.constant.mark.InputMark.DOWN;
import static bridge.constant.mark.InputMark.UP;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();

            addMarkToBridge(bridge, number);
        }
        return bridge;
    }

    private void addMarkToBridge(List<String> bridge, int number) {
        if (isUp(number)) {
            bridge.add(UP.getMark());
        }

        if (isDown(number)) {
            bridge.add(DOWN.getMark());
        }
    }

    private boolean isUp(int number) {
        return number == ONE;
    }

    private boolean isDown(int number) {
        return number == ZERO;
    }
}
