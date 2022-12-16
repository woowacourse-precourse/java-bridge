package bridge;

import bridge.BridgeNumberGenerator;
import bridge.util.BridgeShapeInfo;

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

        for(int i = 0; i < size; i++) {
            bridge.add(getBridgeShape());
        }

        return bridge;
    }

    /**
     * 각각의 다리 모양을 구하는 함수
     * @return U | D
     */
    public String getBridgeShape() {
        int bridgeNumber = getBridgeNumber();
        BridgeShapeInfo bridgeShapeInfo = BridgeShapeInfo.getBridgeShapeInfoWithNumber(bridgeNumber);
        notBridgeShape(bridgeShapeInfo);
        return bridgeShapeInfo.getBridgeShape();
    }

    public int getBridgeNumber() {
        return bridgeNumberGenerator.generate();
    }

    public void notBridgeShape(BridgeShapeInfo bridgeShapeInfo) {
        if (bridgeShapeInfo == null) {
            throw new IllegalArgumentException();
        }
    }
}
