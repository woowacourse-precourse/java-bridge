package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int SIZE_LOWER_INCLUSIVE = 3;
    private static final int SIZE_UPPER_INCLUSIVE = 20;
    private static final String SIZE_OUT_OF_RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
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
        List<String> bridge = new ArrayList<>();
        do {
            Direction direction = new Direction(bridgeNumberGenerator.generate());
            bridge.add(direction.getDirection());
        } while (bridge.size() < size);
        return bridge;
    }

    private void validate(int size) {
        if (size < SIZE_LOWER_INCLUSIVE || size > SIZE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(SIZE_OUT_OF_RANGE_ERROR);
        }
    }
}
