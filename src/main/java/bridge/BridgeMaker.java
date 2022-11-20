package bridge;

import bridge.model.Direction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸은 "U", 아래 칸은 "D"로 표현된다.
     */
    public List<String> makeBridge(int size) {
        return Stream.generate(() -> Direction.of(bridgeNumberGenerator.generate()).getToken())
                .limit(size)
                .collect(Collectors.toList());
    }
}
