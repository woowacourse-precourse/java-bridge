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

    // TODO: 더 효율적으로 코드 작성할 수 있는 방법(ex.enum)생각해보기
    public String returnMove(int number) {
        String direction = "";
        if (number == 0) {
            direction = "D";
        }
        if (number == 1) {
            direction = "U";
        }
        return direction;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> answerBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            answerBridge.add(returnMove(bridgeNumberGenerator.generate()));
        }
        return answerBridge;
    }
}
