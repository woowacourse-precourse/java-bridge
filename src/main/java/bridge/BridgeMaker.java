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

    public List<String> makeBridge(int size) {
        List<String> bridgeRoad = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int road = bridgeNumberGenerator.generate();
            if(road == 1)
                bridgeRoad.add("U");
            if(road == 0)
                bridgeRoad.add("D");
        }
        return bridgeRoad;
    }
}
