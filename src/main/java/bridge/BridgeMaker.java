package bridge;

import bridge.domain.Constants;
import bridge.domain.Direction;
import bridge.exception.IllegalArgumentError;
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

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        validateRange(size);
        for (int i = 0; i < size; i++) {
            int number = this.bridgeNumberGenerator.generate();
            bridge.add(Direction.toDirection(number).getDirectionString());
        }
        return bridge;
    }

    public void validateRange(int size) {
        if (!(size >= Constants.LOWER_BOUND_OF_BRIDGE_SIZE && size <= Constants.UPPER_BOUND_OF_BRIDGE_SIZE)) {
            throw new IllegalArgumentError("다리 범위를 벗어납니다.");
        }
    }
}