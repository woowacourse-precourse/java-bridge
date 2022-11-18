package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public static final String UP_STAIRS="U";
    public static final String DOWN_STAIRS="D";

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
        for (int space = 1; space <= size; space++) {
            makeOneSpace(bridge);
        }
        return bridge;
    }

    private void makeOneSpace(List<String> bridge) {
        int generateNum = bridgeNumberGenerator.generate();
        if (generateNum == 1) {
            bridge.add(UP_STAIRS);
        }else{
            bridge.add(DOWN_STAIRS);
        }
    }
}
