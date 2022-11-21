package bridge;

import bridge.domain.utils.Space;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.utils.Space.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final int UP_NUMBER = 1;

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
            int answerSpace = bridgeNumberGenerator.generate();
            addToStringList(answerSpace, answerBridge);
        }
        return answerBridge;
    }

    private void addToStringList(int answerSpace, List<String> answerBridge) {
        if (answerSpace == DOWN.getIndex()) {
            answerBridge.add(DOWN.getRepresented());
        } else if (answerSpace == UP_NUMBER) {
            answerBridge.add(UP.getRepresented());
        }
    }
}
