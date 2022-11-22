package bridge;

import bridge.utils.enums.MoveFormat;
import bridge.utils.Validator;

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

    public List<String> makeBridge(int size) {
        validate(size);

        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String square = generateSquare();
            bridge.add(square);
        }
        return bridge;
    }

    private void validate(int size) {
        Validator.checkSizeInRange(size);
    }

    private String generateSquare() {
        int bridgeValue = bridgeNumberGenerator.generate();
        return MoveFormat.findLabelByValue(bridgeValue);
    }
}
