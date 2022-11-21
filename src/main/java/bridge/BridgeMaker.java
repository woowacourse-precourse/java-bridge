package bridge;

import bridge.model.domains.constants.Step;
import bridge.model.domains.validator.BridgeValidator;

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
        BridgeValidator.validateBridgeSize(size);
        List<String> bridge = new ArrayList<>();
        while (bridge.size() < size) {
            addStepKeywordToBridge(bridge);
        }
        return bridge;
    }

    private void addStepKeywordToBridge(List<String> bridge) {
        int bridgeNumber = bridgeNumberGenerator.generate();
        String step = convertToStep(bridgeNumber);
        BridgeValidator.validateStep(step);
        bridge.add(step);
    }

    private static String convertToStep(int bridgeNumber) {
        if (bridgeNumber == 1) {
            return Step.UP.getValue();
        }
        if (bridgeNumber == 0) {
            return Step.DOWN.getValue();
        }
        return null;
    }
}
