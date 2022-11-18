package bridge.domain;

import static bridge.constant.BridgeConstant.RESTART_GAME;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int round = 0;
    private int tryCount = 1;
    private boolean gameClear = false;

    public Bridge getBridge(int size) {
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        return new Bridge(bridge);
    }

    public MoveResult move(Bridge bridge,
                           String moveMessage) {
        boolean moveSuccess = bridge.isMoveSuccess(round++, moveMessage);
        return new MoveResult(moveMessage, moveSuccess);
    }

    public boolean retry(String retryMessage) {
        if (retryMessage.equals(RESTART_GAME)) {
            round = 0;
            tryCount++;
            return true;
        }
        return false;
    }

    public boolean isGameClear(Bridge bridge) {
        if (bridge.isGameClear(round)) {
            gameClear = true;
            return true;
        }
        return false;
    }

    public GameResult getResult() {
        return new GameResult(tryCount, gameClear);
    }
}
