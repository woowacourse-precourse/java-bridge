package bridge.domain;

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

    public Bridge makeBridge(BridgeSize size) {
        List<BridgeStep> steps = new ArrayList<>();
        for (int count = 1; count <= size.getSize(); count++) {
            steps.add(BridgeStep.valueOf(String.valueOf(bridgeNumberGenerator.generate())));
        }
        return BridgeFactory.from(size, steps);
    }
}
