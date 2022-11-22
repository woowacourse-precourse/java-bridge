package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final int MIN_BRIDGE_SIZE = 3;
    private final int MAX_BRIDGE_SIZE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateBridgeSize(size);

        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(
                    bridgeSwitch(
                            bridgeNumberGenerator.generate()
                    ));
        }
        return bridge;
    }

    private void validateBridgeSize(int bridgeSize) {
        if (!(bridgeSize >= MIN_BRIDGE_SIZE && bridgeSize <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private String bridgeSwitch(int number) {
        if (number == 0) {
            return "D";
        }
        if (number == 1) {
            return "U";
        }
        throw new IllegalArgumentException("[ERROR] 예상하지 못한 난수가 생성되었습니다.");
    }
}
