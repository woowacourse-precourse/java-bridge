package bridge.domain;

import bridge.controller.BridgeGameController;
import bridge.controller.InputController;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<MoveResult> moveResults;
    private Bridge bridge;
    private boolean exit;

    public BridgeGame(List<MoveResult> moveResults, Bridge bridge) {
        this.moveResults = moveResults;
        this.bridge = bridge;
        this.exit = false;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<MoveResult> getMoveResults() {
        return moveResults;
    }
    public void move() {
        MoveSpace moveSpace = InputController.getMoving();
        this.moveResults.add(this.bridge.createMoveResult(moveSpace));

        for (int i = 0; i < this.moveResults.size(); i++) {
            System.out.print(i);
            this.moveResults.get(i).pringMoveResult(this.moveResults.get(i));
        }

        System.out.println(this.moveResults);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.moveResults = new ArrayList<>();
        this.bridge.resetStep();
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
}
