package bridge;

import static bridge.constant.BridgeConstant.RESTART_GAME;

import bridge.exception.Validator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int round = 0;
    private int tryCount = 1;
    private boolean isGameClear = false;

    public List<String> getBridge(int size) {
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    public MessageToResult move(List<String> bridge,
                        String moveMessage) {
        boolean isCorrect = bridge.get(round++).equals(moveMessage);
        return new MessageToResult(moveMessage, isCorrect);
    }

    public boolean retry(String retryMessage) {
        if (retryMessage.equals(RESTART_GAME)) {
            round = 0;
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

    public FinalMessage getResult() {
        return new FinalMessage(tryCount, isGameClear);
    }
}
