package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public int readBridgeSize() {
        InputView inputView = new InputView();
        String bridgeSize = inputView.readBridgeSize();
        return validateBridgeSize(bridgeSize);
    }

    private int validateBridgeSize(String bridgeSize) {
        int integerBridgeSize = 0;
        integerBridgeSize = validateBridgeSizeInteger(bridgeSize);
        validateBridgeSizeRange(integerBridgeSize);
        return integerBridgeSize;
    }

    private void validateBridgeSizeRange(int integerBridgeSize) {
        if (integerBridgeSize < 3 || integerBridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private int validateBridgeSizeInteger(String bridgeSize) {
        int integerBridgeSize;
        try {
            integerBridgeSize = Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return integerBridgeSize;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            buildBridge(bridge);
        }
        return bridge;
    }

    private void buildBridge(List<String> bridge) {
        int randomNumber = bridgeNumberGenerator.generate();
        if (randomNumber == 0) {
            bridge.add("D");
        } else if (randomNumber == 1) {
            bridge.add("U");
        }
    }
}
