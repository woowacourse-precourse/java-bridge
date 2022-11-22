package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

//다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> randomBridge =
                Stream.generate(() -> {
                    if (bridgeNumberGenerator.generate() == 1) return "U";
                    return "D";
                }).limit(size)
                        .collect(Collectors.toList());

        return randomBridge;
    }
}
