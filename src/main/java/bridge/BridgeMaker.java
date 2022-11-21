package bridge;

import bridge.domain.BridgeCell;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validate(size);
        List<String> bridge = new ArrayList<>(size);
        while (bridge.size() < size) {
            int number = bridgeNumberGenerator.generate();
            BridgeCell cell = BridgeCell.getBridgeCell(number);
            bridge.add(cell.getSignature());
        }
        return bridge;
    }

    private void validate(int size) {
        if (isOutOfBounds(size)) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3 이상 20 이하입니다.");
        }
    }

    private boolean isOutOfBounds(int size) {
        return size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE;
    }
}
