package bridge;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.config.BridgeGameCommand.COMMAND_BRIDGE_DOWN;
import static bridge.config.BridgeGameCommand.COMMAND_BRIDGE_UP;
import static bridge.config.BridgeGameConfig.BRIDGE_UP_NUMBER;

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
        ArrayList<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (bridgeNumberGenerator.generate() == BRIDGE_UP_NUMBER) {
                bridge.add(COMMAND_BRIDGE_UP);
                continue;
            }
            bridge.add(COMMAND_BRIDGE_DOWN);
        }
        return bridge;
    }
}
