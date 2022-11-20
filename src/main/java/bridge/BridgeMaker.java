package bridge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final Map<Integer, String> UP_OR_DOWN = Map.of(
            1, Constants.CODE_UP,
            0, Constants.CODE_DOWN
    );

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
                .mapToObj(i -> UP_OR_DOWN.get(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }
}
