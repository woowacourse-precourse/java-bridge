package bridge;

import java.util.List;

public class BridgeGameService {

    private int round = 0;

    public List<String> createBridge(int size) {
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    public boolean isCorrectMove(List<String> bridge, String moveMessage) {
        return bridge.get(round++).equals(moveMessage);
    }
}
