package bridge.service;

import bridge.domain.Bridge;
import bridge.type.DirectionType;
import utils.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final int initialTryCnt = 0;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        Bridge bridge = Bridge.getInstance();
        bridge.init(getBridgeList(size), initialTryCnt);
        return bridge.getBridgeInfo();
    }


    public List<String> getBridgeList(int size) {
        List<String> bridge = new ArrayList<>();
        for (int idx = 0; idx < size; idx++) {
            bridge.add(getCrossable());
        }
        return bridge;
    }


    public String getCrossable () {
        if (bridgeNumberGenerator.generate() == 0) {
            return DirectionType.DOWN.getDirection();
        }
        return DirectionType.UP.getDirection();
    }

}
