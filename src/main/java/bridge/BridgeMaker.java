package bridge;

import java.util.LinkedList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(final int size) {
        final List<String> bridge = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            final int number = bridgeNumberGenerator.generate();
            validateNumber(number);
            final String bridgeCourse = getBridgeCourse(number);
            bridge.add(bridgeCourse);
        }
        return bridge;
    }

    private void validateNumber(final int number) {
        if (number != 1 && number != 0) {
            throw new IllegalArgumentException("[ERROR] 랜덤 값은 0 또는 1이어야 합니다.");
        }
    }

    private String getBridgeCourse(final int number) {
        if (number == 1) {
            return "U";
        }
        return "D";
    }
}
