package bridge;

import bridge.controller.InputController;
import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.view.OutputView;

public class BridgeGame {

    private static final Boolean CORRECT_ANSWER = Boolean.TRUE;
    private static final Boolean WRONG_ANSWER = Boolean.FALSE;

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
        if (!player.matchPlayerAndBridge(bridge)) {
            return false;
        }
        return true;
    }

    private void judgeTrue() {
        result.setGameResult(CORRECT_ANSWER);
        OutputView.printMap(result, player);
    }

    private void judgeFalse() {
        result.setGameResult(WRONG_ANSWER);
        OutputView.printMap(result, player);
    }

    private void retry() {
        judgeFalse();
        if (inputController.retryCommandInput()) {
            result.updateNumberOfTrials();
            player.resetPlayer();
            result.resetGameResult();
            move();
        }
    }
}
