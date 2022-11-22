package bridge;

import bridge.exeption.Validator;

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
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(checkUpDown(number));
        }

        validateBridge(size, bridge);
        return bridge;
    }

    public void validateBridge(int size, List<String> bridge) {
        Validator validator = new Validator();

        validator.checkBridgeSize(size, bridge);
        validator.checkBridgeWord(size, bridge);
    }

    private String checkUpDown(int number) {
        if (number == 0) return "D";
        return "U";
    }
}
