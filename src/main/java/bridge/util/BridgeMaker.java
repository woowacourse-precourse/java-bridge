package bridge.util;

import bridge.util.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static List<String> computerBridges = new ArrayList<>();

    private static final String UP = "U";
    private static final String DOWN = "D";


    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {

        for(int i=0;i<size;i++) {
            int number = bridgeNumberGenerator.generate();
            if (number == 0) {
                computerBridges.add(DOWN);
                continue;
            }
            computerBridges.add(UP);
        }
        return computerBridges;
    }

}
