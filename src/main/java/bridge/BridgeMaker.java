package bridge;

import bridge.model.constant.BridgeLengthRule;
import bridge.model.constant.BridgePattern;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    // 변경 불가
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>(size);
        addElement(bridge, size);

        return bridge;
    }

    private void addElement(List<String> bridge, int size) {
        BridgeLengthRule.validLength(size);
        for (int cnt = 0; cnt < size; cnt++) {
            bridge.add(BridgePattern.convertNumberToMove(bridgeNumberGenerator.generate()));
        }
    }
}
