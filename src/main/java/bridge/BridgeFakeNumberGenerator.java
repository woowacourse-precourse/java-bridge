package bridge;

public class BridgeFakeNumberGenerator implements BridgeNumberGenerator{
    private int count;

    @Override
    public int generate() {
        count++;
        return count % 2;
    }
}
