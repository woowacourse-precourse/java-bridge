package bridge;

import bridge.domain.enums.BridgePanel;
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

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>(size);
        for (int index = 0; index < size; index++) {
            getPanelByNumber(bridge);
        }
        return bridge;
    }

    public void getPanelByNumber(List<String> bridge) {
        int number = bridgeNumberGenerator.generate();
        if (number == BridgePanel.UP_PANEL.getNumber()) {
            bridge.add(BridgePanel.UP_PANEL.getPosition());
        }
        if (number == BridgePanel.DOWN_PANEL.getNumber()) {
            bridge.add(BridgePanel.DOWN_PANEL.getPosition());
        }
    }
}