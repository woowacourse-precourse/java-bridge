package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final int MINIMUM_BRIDGE_LENGTH = 3;
    private final int MAXIMUM_BRIDGE_LENGTH = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final List<String> DIRECTIONS = newArrayList(
            Direction.DOWN.toString(), Direction.UP.toString());

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateLengthOfBridge(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int binary = this.bridgeNumberGenerator.generate();
            bridge.add(DIRECTIONS.get(binary));
        }
        return bridge;
    }

    private void validateLengthOfBridge(int size) {
        if (size < MINIMUM_BRIDGE_LENGTH || size > MAXIMUM_BRIDGE_LENGTH) {
            String errorMessage = "[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.";
            throw new IllegalArgumentException(String.format(
                    errorMessage, MINIMUM_BRIDGE_LENGTH, MAXIMUM_BRIDGE_LENGTH));
        }
    }
}
