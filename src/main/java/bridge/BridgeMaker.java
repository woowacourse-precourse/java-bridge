package bridge;

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
        List<String> bridge = new ArrayList<>();
        for (int bridgeIdx = 0; bridgeIdx < size; bridgeIdx++) {
            int randNum = bridgeNumberGenerator.generate();
            addDataInBridge(bridge,randNum);
        }
        return bridge;
    }

    /**
     * 난수로 생성된 값이 0인지 1인지 판별하여 그에 맞는 값을 bridge 리스트에 저장한다.
     */
    public void addDataInBridge(List<String> bridge, int randomNum) {
        if (randomNum == 0) {
            bridge.add("D");
        }
        if (randomNum == 1) {
            bridge.add("U");
        }
    }
}
