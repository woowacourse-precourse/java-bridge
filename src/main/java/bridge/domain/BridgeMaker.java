package bridge.domain;

import bridge.BridgeKey;
import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> bridgeNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridgeNumbers.add(bridgeNumberGenerator.generate());
        }

        return upOrDownBridge(bridgeNumbers);
    }

    private List<String> upOrDownBridge(List<Integer> bridgeNumbers) {
        return bridgeNumbers.stream()
                .map(BridgeKey::bridgeKey)
                .collect(Collectors.toList());
    }
}
