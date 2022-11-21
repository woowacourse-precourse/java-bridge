package bridge;

import bridge.exception.Validator;
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

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        Validator.validateBridgeSize(size);
        List<String> answerBridge = new ArrayList<>();
        for (int round = 0; round < size; round++) {
            answerBridge.add(convertNumberToUpDown(bridgeNumberGenerator.generate()));
        }
        return answerBridge;
    }

    private String convertNumberToUpDown(int number) {
        Validator.validateRandomsInput(number);
        if (number == 1) {
            return "U";
        }
        return "D";
    }
}
