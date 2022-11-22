package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.MoveSign.DOWN;
import static bridge.domain.MoveSign.UP;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int generate = bridgeNumberGenerator.generate();
            if (generate == DOWN.getMoveNumber()) {
                bridge.add(DOWN.getMoveContent());
                continue;
            }
            bridge.add(UP.getMoveContent());
        }
        return bridge;
    }
}
