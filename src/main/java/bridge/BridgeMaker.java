package bridge;

import constant.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    public static final int UP = 1;
    public static final int INITIAL_INDEX = 0;
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
        for (int index = INITIAL_INDEX; index < size; index++) {
            appendBridge(bridge);
        }
        return bridge;
    }

    public void appendBridge(List<String> bridge) {
        if (bridgeNumberGenerator.generate() == UP) {
            bridge.add(Message.UP);
            return;
        }
        bridge.add(Message.DOWN);
    }
}
