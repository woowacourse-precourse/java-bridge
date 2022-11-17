package bridge;

import static bridge.constant.BridgeConstant.RESTART_GAME;

import java.util.List;

public class BridgeGameService {

    private int round = 0;
    private int tryCount = 1;

    public List<String> createBridge(int size) {
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    public boolean isCorrectMove(List<String> bridge, String moveMessage) {
        return bridge.get(round++).equals(moveMessage);
    }
    public boolean isRetry(String retryMessage) {
        if (retryMessage.equals(RESTART_GAME)) {
            tryCount++;
            return true;
        }
        return false;
    }
}
