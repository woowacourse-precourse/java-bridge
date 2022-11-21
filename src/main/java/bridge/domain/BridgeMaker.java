package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.Constants.*;

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
        return addBridgeArrow(bridge, size);
    }

    private List<String> addBridgeArrow(List<String> bridge, int size) {
        while (size-- > 0) {
            int bridgeRandomNumber = bridgeNumberGenerator.generate();
            bridge.add(convertBridgeRandomNumberToUpDownMark(bridgeRandomNumber));
        }
        return bridge;
    }

    private String convertBridgeRandomNumberToUpDownMark(int bridgeRandomNumber) {
        if (bridgeRandomNumber == BRIDGE_DOWN_NUMBER) {
            return DOWN;
        }
        return UP;
    }
}
