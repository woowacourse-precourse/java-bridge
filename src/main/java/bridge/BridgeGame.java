package bridge;

import bridge.controller.InputController;
import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Result result;
    private final InputController inputController;
    private final Player player = new Player();

    public BridgeGame(Bridge bridge, Result result, InputController inputController) {
        this.bridge = bridge;
        this.result = result;
        this.inputController = inputController;
    }

    public void move() {
        for (int trialNum = 0; trialNum < bridge.getBridgeSize(); trialNum++) {
            movePlayer();
            if (!checkAnswer()) {
                retry();
                break;
            }
            judgeTrue();
        }
    }

    private void movePlayer() {
        Movement movementInput = inputController.getDirectionInput();
        player.updateMovement(movementInput);
    }

    private boolean checkAnswer() {
        // 브릿지로 옮길까?
        if (!player.matchPlayerAndBridge(bridge)) {
            return false;
        }
        return true;
    }

    private void judgeTrue() {

        result.setGameResult(Boolean.TRUE);
        OutputView.printMap(result, player);
    }

    private void judgeFalse() {
        result.setGameResult(Boolean.FALSE);
        OutputView.printMap(result, player);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        judgeFalse();
        if (inputController.retryCommandInput()) {
            result.updateNumberOfTrials();
            player.resetPlayer();
            result.resetGameResult();
            move();
        }
    }
}
