package bridge.model;

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
        List<String> bridge = new ArrayList<String>();
        String move;
        while (size-- > 0) {
            move = "U";
            int randomNum = this.bridgeNumberGenerator.generate();
            if (randomNum == 0) {
                move = "D";
            }
            bridge.add(move);
        }
        return bridge;
    }
}
