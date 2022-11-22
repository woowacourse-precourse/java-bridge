package bridge.model;

import bridge.BridgeNumberGenerator;

class BridgeFakeOneZeroLoopNumberGenerator implements BridgeNumberGenerator {
    public static final int INT_VALUE = 2;
    private int count;

    @Override
    public int generate() {
        return (++count) % INT_VALUE;
    }
}
