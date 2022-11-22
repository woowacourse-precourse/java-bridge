package bridge;

import bridge.Domain.BridgeRow;

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
        List<String> bridge = new ArrayList<>();
        for(int repeat = 0; repeat < size; repeat++){
            int random = bridgeNumberGenerator.generate();
            bridge.add(BridgeRow.getRowUsingNumber(random));
        }
        return bridge;
    }
}
