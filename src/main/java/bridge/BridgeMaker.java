package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final int NUMBER_UP = 1;
    private static final int NUMBER_DOWN = 0;
    private static final String STRING_UP = "U";
    private static final String STRING_DOWN = "D";

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            makeOneBlock(bridge, randomNumber);
        }
        return bridge;
    }

    public void makeOneBlock(List<String> bridge, int randomNumber) {
        if (randomNumber == NUMBER_DOWN) {
            bridge.add(STRING_DOWN);
        } else if (randomNumber == NUMBER_UP) {
            bridge.add(STRING_UP);
        }
    }
}
