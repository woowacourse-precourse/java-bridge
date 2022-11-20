package bridge.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    public static final String UP_BRIDGE = "U";
    public static final String DOWN_BRIDGE = "D";
    public static final int DOWN_DEFAULT_VALUE = 0;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> bridgeNumberGenerator.generate())
                .map(this::changeToDirection)
                .collect(Collectors.toList());
    }

    private String changeToDirection(Integer value) {
        if (value == DOWN_DEFAULT_VALUE) {
            return DOWN_BRIDGE;
        }
        return UP_BRIDGE;
    }
}
