package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int UP_BRIDGE = 1;
    private static final int DOWN_BRIDGE = 0;
    private static final int BRIDGE_LINE = 2;
    private List<String> bridge;
    private HashMap<String, List<String>> presentBridge;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void makeBridges(int size) {
        makeBridge(size);
        initPresentBridge();
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        this.bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (bridgeNumberGenerator.generate() == UP_BRIDGE) {
                this.bridge.add("U");
            } else {
                this.bridge.add("D");
            }
        }
        return this.bridge;
    }

    public void initPresentBridge() {
        this.presentBridge = new HashMap<>();
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public HashMap<String, List<String>> getPresentBridge() {
        return this.presentBridge;
    }

    public void setPresentBridge(HashMap<String, List<String>> presentBridge) {
        this.presentBridge = presentBridge;
    }

}
