package bridge;

import static bridge.constant.BridgeConstant.RESTART_GAME;

import java.util.List;

public class BridgeGameService {

    private int round = 0;
    private int tryCount = 1;
    private boolean isGameClear = false;

    public List<String> createBridge(int size) {
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    public boolean isCorrectMove(List<String> bridge, String moveMessage) {
        return bridge.get(round++).equals(moveMessage);
    }

    public void restart() {
        round = 0;
    }

    public boolean isRetry(String retryMessage) {
        if (retryMessage.equals(RESTART_GAME)) {
            tryCount++;
            return true;
        }
        return false;
    }

    public boolean isGameClear(List<String> bridge) {
        if (bridge.size() == round) {
            isGameClear = true;
            return true;
        }
        return false;
    }
}
