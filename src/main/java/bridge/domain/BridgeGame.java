package bridge.domain;

import bridge.MoveResults;
import bridge.domain.Bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final MoveResults moveResults;

    public BridgeGame(Bridge bridge, MoveResults moveResults) {
        this.bridge = bridge;
        this.moveResults = moveResults;
    }

    public void move(String controlKey) {
        moveResults.addResult(bridge.moveResult(moveResults().size(), controlKey));
    }

    public MoveResults moveResults() {
        return moveResults;
    }

    public void retry(String controlKey) {
        moveResults.removeFailure();
        move(controlKey);
    }

}
