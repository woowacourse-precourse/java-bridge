package bridge.util;

import bridge.BridgeNumberGenerator;

import static bridge.enums.BridgeStatus.LOWER;
import static bridge.enums.BridgeStatus.UPPER;

public class BridgeConvertor {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeConvertor(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public String bridgeConverter() {
        int generate = bridgeNumberGenerator.generate();
        if (isUpper(generate)) {
            return UPPER.getStatus();
        }
        return LOWER.getStatus();
    }

    boolean isUpper(int number) {
        return number == 1;
    }
}
