package bridge.model;

import bridge.BridgeNumberGenerator;

class BridgeFakeOneZeroLoopNumberGenerator implements BridgeNumberGenerator {
    private int count;

    @Override
    public int generate() {
        return (++count) % 2;
    }
}
