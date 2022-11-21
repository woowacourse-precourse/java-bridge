package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final int ANSWER_UP_BRIDGE_INT = 1;
    private final String ANSWER_UP_BRIDGE_STRING = "U";
    private final String ANSWER_DOWN_BRIDGE_STRING = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeAnswers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bridgeAnswers.add(generateAnswer());
        }

        return bridgeAnswers;
    }

    private String generateAnswer() {
        int answer = bridgeNumberGenerator.generate();

        if (answer == ANSWER_UP_BRIDGE_INT) {
            return ANSWER_UP_BRIDGE_STRING;
        }

        return ANSWER_DOWN_BRIDGE_STRING;
    }
}
