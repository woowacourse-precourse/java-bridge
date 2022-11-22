package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final String ERROR_BRIDGE_SIZE = "[ERROR] 다리 길이는 3 이상 20 이하입니다.";
    private final BridgeNumberGenerator bridgeNumberGenerator;
    public static boolean valueError = false;

    private final int MIN_SIZE = 3;
    private final int MAX_SIZE = 20;
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        valueError = dealBridgeError(size);
        if (valueError) {
            return null;
        }
        for (int time = 0; time < size; time++) {
            String direction = toDirection(bridgeNumberGenerator.generate());
            bridge.add(direction);
        }
        return bridge;
    }

    private boolean dealBridgeError(int size) {
        try {
            checkRangeValidity(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public void checkRangeValidity(int size) throws IllegalArgumentException {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            valueError = true;
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
    }

    private String toDirection(int bridgeNumber) {
        if (bridgeNumber == 0) {
            return "D";
        }
        return "U";
    }
}
