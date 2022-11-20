package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.direction.Direction.DOWNWARD_DIRECTION;
import static bridge.domain.direction.Direction.UPWARD_DIRECTION;

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
        validateSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(mapToDirection(number));
        }
        return bridge;
    }

    private void validateSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private String mapToDirection(int number) {
        if (number == 0) {
            return UPWARD_DIRECTION;
        }
        return DOWNWARD_DIRECTION;
    }
}
