package bridge.model;

// BridgeFakeNumberGenerator (테스트용; 1,0,1,0 순환하면서 숫자생성)
class BridgeFakeOneZeroLoopNumberGenerator implements BridgeNumberGenerator {
    private int count;

    @Override
    public int generate() {
        count++;
        return count % 2;
    }
}
