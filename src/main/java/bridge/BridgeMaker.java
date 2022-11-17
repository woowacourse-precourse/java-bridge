package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final String UP_SPACE_STRING = "U";
    private static final String DOWN_SPACE_STRING = "D";
    private static final int UP_SPACE_INT = 1;
    private static final int DOWN_SPACE_INT = 0;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> answerBridge = new ArrayList<>();

        for (int count = 0; count < size; count++) {
            int crossabeleSpace = bridgeNumberGenerator.generate();
            addCrossableSpace(crossabeleSpace, answerBridge);
        }
        return answerBridge;
    }

    private void addCrossableSpace(int crossabeleSpace, List<String> answerBridge) {
        if (crossabeleSpace == DOWN_SPACE_INT) {
            answerBridge.add(DOWN_SPACE_STRING);
        } else if (crossabeleSpace == UP_SPACE_INT) {
            answerBridge.add(UP_SPACE_STRING);
        }
    }
}
