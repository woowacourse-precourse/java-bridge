package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    private final int MIN_BRIDGE_SIZE = 3;
    private final int MAX_BRIDGE_SIZE = 20;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateNumberSize(size);

        return generateBridge(size);
    }

    private List<String> generateBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (bridgeNumberGenerator.generate() == 0) {
                bridge.add(InputMatcher.DOWNSIDE_OF_BRIDGE.sideOfBridge);
                continue;
            }
            bridge.add(InputMatcher.UPSIDE_OF_BRIDGE.sideOfBridge);
        }

        return bridge;
    }

    private void validateNumberSize(int size) throws IllegalArgumentException {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(String.format("[ERROR] 다리 길이는 %s부터 %s 사이의 숫자여야 합니다.", MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE));
        }
    }
}
