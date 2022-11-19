package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String ERROR_BRIDGE_SIZE = String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.", MIN_BRIDGE_SIZE,
            MAX_BRIDGE_SIZE);

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateBridgeSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0 ; i < size; ++i) {
            int randomNumber = bridgeNumberGenerator.generate();
            String moving = mappingNumber(randomNumber);
            bridge.add(moving);
        }
        return bridge;
    }

    private String mappingNumber(int number) {
        if (number == 0) {
            return "D";
        }
        if (number == 1) {
            return "U";
        }
        throw new IllegalArgumentException("0과 1 이외에는 mapping 할 수 없습니다");
    }

    private void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
    }
}
