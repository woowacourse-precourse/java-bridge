package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final String NUMBER_NOT_ZERO_ONE = "[ERROR] 전달받은 숫자가 0 혹은 1이 아닙니다.";
    private static final String DOWN_BRIDGE = "D";
    private static final String UP_BRIDGE = "U";
    private static final int DOWN = 0;
    private static final int UP = 1;

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

        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();

            bridge.add(generateUpDown(number));
        }

        return bridge;
    }
    private String generateUpDown(int number) {
        if (number == DOWN)
            return DOWN_BRIDGE;
        if (number == UP )
            return UP_BRIDGE;

        throw new IllegalArgumentException(NUMBER_NOT_ZERO_ONE);
    }
}
