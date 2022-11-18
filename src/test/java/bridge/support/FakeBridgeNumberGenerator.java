package bridge.support;

import bridge.domain.BridgeNumberGenerator;

public class FakeBridgeNumberGenerator implements BridgeNumberGenerator {

    private boolean isOne;

    @Override
    public int generate() {
        int returnValue = 0;
        if (isOne) {
            returnValue = 1;
        }
        isOne = !isOne;
        return returnValue;
    }
}
