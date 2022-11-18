package bridge;

public class BridgeSize implements BridgeNumberGenerator {

    @Override
    public int generate() {
        return InputView.readBridgeSize();
    }
}
