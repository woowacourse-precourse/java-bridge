package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final int size;
    private int now = -1;

    public Bridge() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printRequestBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        size = bridge.size();
    }

    public void reuse() {
        now = -1;
    }

    public int size() {
        return size;
    }

    public boolean canMove(String moving) {
        int next = ++now;
        return bridge.get(next).equals(moving);
    }

    public String getNow() {
        return bridge.get(now);
    }
}
