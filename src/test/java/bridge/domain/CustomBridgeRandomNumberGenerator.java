package bridge.domain;

import bridge.BridgeNumberGenerator;

public class CustomBridgeRandomNumberGenerator implements BridgeNumberGenerator {

    private static final int FIXED_NUMBER = 1;

    @Override
    public int generate() {
        return FIXED_NUMBER;
    }
}
