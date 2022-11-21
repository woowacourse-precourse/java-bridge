package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.enumeration.BridgeStatus.DOWN;
import static bridge.domain.enumeration.BridgeStatus.UP;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        checkValid(size);
        List<String> bridge = new ArrayList<>();
        for (int idx = 0; idx < size; idx++) {
            int randNumber = bridgeNumberGenerator.generate();
            addBridge(bridge, randNumber);
        }
        return bridge;
    }

    private void checkValid(int size) {
        if (size < MIN_RANGE || size > MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void addBridge(List<String> bridge, int randNumber) {
        if (randNumber == UP.getNumber()) {
            bridge.add(UP.getName());
        }
        if (randNumber == DOWN.getNumber()) {
            bridge.add(DOWN.getName());
        }
    }
}
