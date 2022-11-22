package bridge;

import static bridge.utils.constants.BridgeConstants.DOWN_CROSS;
import static bridge.utils.constants.BridgeConstants.DOWN_CROSS_VALUE;
import static bridge.utils.constants.BridgeConstants.UP_CROSS;
import static bridge.utils.constants.BridgeConstants.UP_CROSS_VALUE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        addCrossValue(size, bridge);
        return Collections.unmodifiableList(bridge);
    }

    private void addCrossValue(int size, List<String> bridge) {
        for (int loc = 0; loc < size; loc++) {
            int generate = bridgeNumberGenerator.generate();
            addUpCross(bridge, generate);
            addDownCross(bridge, generate);
        }
    }

    private void addUpCross(List<String> bridge, int generate) {
        if (generate == UP_CROSS_VALUE) {
            bridge.add(UP_CROSS);
        }
    }

    private void addDownCross(List<String> bridge, int generate) {
        if (generate == DOWN_CROSS_VALUE) {
            bridge.add(DOWN_CROSS);
        }
    }
}
