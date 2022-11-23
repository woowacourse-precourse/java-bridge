package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.InputController;
import bridge.domain.Bridge;
import bridge.domain.MoveResult;
import bridge.domain.MoveSpace;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<MoveResult> moveResults;
    private Bridge bridge;
    private boolean exit;
    private int gameCount;

    public BridgeGame(List<MoveResult> moveResults, Bridge bridge) {
        this.moveResults = moveResults;
        this.bridge = bridge;
        this.exit = false;
        this.gameCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<MoveResult> getMoveResults() {
        return moveResults;
    }

    public void move(MoveSpace moveSpace) {
        this.moveResults.add(this.bridge.createMoveResult(moveSpace));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<MoveResult> retry() {
        this.moveResults = new ArrayList<>();
        this.bridge.resetStep();
        this.gameCount += 1;
        return moveResults;
    }

    public boolean isFailedGame() {
        if (!this.bridge.isCurrentMovable(this.moveResults)) {
            return true;
        }
        return false;
    }

    public boolean notExit() {
        if (!this.exit) {
            return true;
        }
        return false;
    }

    public int getCount() {
        return gameCount;
    }

    public void exit() {
        this.exit = true;
    }
}
