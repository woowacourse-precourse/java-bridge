package bridge;

import bridge.domain.constant.BridgeDirection;

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
     * @param bridgeLength 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */

    public List<String> makeBridge(int bridgeLength) {
        List<String> bridge = Stream.generate(bridgeNumberGenerator::generate)
                                        .limit(bridgeLength)
                                        .map(BridgeDirection::transformToWordDirection)
                                        .collect(Collectors.toUnmodifiableList());
        return bridge;
    }
}
