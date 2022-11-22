package bridge;

import bridge.BridgeNumberGenerator;
import util.Constants;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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
        List<String> bridgeStructure = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            checkZeroOrOne(bridgeNumberGenerator.generate(),bridgeStructure);
        }
        return bridgeStructure;
    }

    public void checkZeroOrOne(int zeroOrOne, List<String> bridge) {
        if (zeroOrOne == Constants.ZERO) {
            bridge.add(Constants.DOWN);
        }
        if (zeroOrOne == Constants.ONE) {
            bridge.add(Constants.UP);
        }
    }
}