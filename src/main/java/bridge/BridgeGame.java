package bridge;

import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private final int size;
    private int stage;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.size = size;
        this.bridge = bridgeMaker.makeBridge(this.size);
        this.stage = 0;
    }

    public void move(String input) {
    }

    public void retry(String input) {

    }
}
