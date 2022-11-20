package bridge;

import bridge.controller.InputController;
import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Player player;
    private final InputController inputController;

    public BridgeGame(Bridge bridge, Player player, InputController inputController) {
        this.bridge = bridge;
        this.player = player;
        this.inputController =inputController;
    }

    public void move() {
        for (int trialNum = 0; trialNum < bridge.getBridgeSize(); trialNum++) {
            movePlayer();
            if (!checkAnswer()) {
                retry(trialNum);
                break;
            }
            judgeTrue(trialNum);
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

    private void judgeTrue(int trialNum) {
        player.updateAnswer(Boolean.TRUE);
        OutputView.printMap(trialNum, player);
    }

    private void judgeFalse(int trialNum) {
        player.updateAnswer(Boolean.FALSE);
        OutputView.printMap(trialNum, player);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int trialNum) {
        judgeFalse(trialNum);
        if (inputController.retryCommandInput()) {
            player.resetPlayer();
            move();
        }
    }
}
