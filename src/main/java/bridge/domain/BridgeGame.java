package bridge.domain;

import static bridge.constant.BridgeConstant.RESTART_GAME;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int round = 1;
    private int tryCount = 1;

    public Bridge getBridge(int size) {
        List<String> blocks = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        return new Bridge(blocks);
    }

    public MoveResult move(Bridge bridge,
                           String moveMessage) {
        boolean isSuccess = bridge.isMoveSuccess(round, moveMessage);
        return new MoveResult(moveMessage, isSuccess);
    }

    public boolean retry(String retryMessage) {
        if (retryMessage.equals(RESTART_GAME)) {
            round = 1;
            tryCount++;
            return true;
        }
        return false;
    }

    public boolean isGameClear(Bridge bridge) {
        if (bridge.isGameClear(round)) {
            return true;
        }
        round++;
        return false;
    }

    public GameResult closeGame(Bridge bridge) {
        return new GameResult(tryCount, bridge.isGameClear(round));
    }
}
