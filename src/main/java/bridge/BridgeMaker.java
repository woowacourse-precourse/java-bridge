package bridge;

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

    public List<String> makeBridge(int size) {
        return Stream.generate(bridgeNumberGenerator::generate)
                .map(this::convertBridgeNumberToBridgeString)
                .limit(size)
                .collect(Collectors.toList());
    }

    private String convertBridgeNumberToBridgeString(int number) {
        return BridgeMapper.convertBridgeNumberToBridgeString(number);
    }
}
