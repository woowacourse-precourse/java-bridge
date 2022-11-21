package bridge.domain;

import bridge.controller.InputController;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int gameCount;

    public List<BridgeResult> getBridgeResults() {
        return bridgeResults;
    }

    private List<BridgeResult> bridgeResults;
    private Bridge bridge;

    private boolean exit;

    public BridgeGame(List<BridgeResult> bridgeResults, Bridge bridge){
        this.bridgeResults = bridgeResults;
        this.bridge = bridge;
        this.gameCount = 1;
        this.exit = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        Move move = InputController.inputMoving();
        this.bridgeResults.add(this.bridge.isGoodMove(move));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.bridgeResults = new ArrayList<>();
        this.bridge.resetStep();
        this.gameCount += 1;
    }

    public void exit() {
        this.exit = true;
    }

    public boolean notExit(){
        if(!this.exit){
            return true;
        }
        return false;
    }

    public boolean isFailedGame(){
        if(!this.bridge.nowGoodMove(this.bridgeResults)){
            return true;
        }
        return false;
    }
}
