package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.view.OutputView;

public class BridgeGame {

    private static final Boolean CORRECT_ANSWER = Boolean.TRUE;
    private static final Boolean WRONG_ANSWER = Boolean.FALSE;
    private final Bridge bridge;
    private final Player player;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }

    public void move(Movement directionInput, Result result) {
        player.updateMovement(directionInput);
        if (!checkAnswer()) {
            judgeFalse(result);
            return;
        }
        judgeTrue(result);
    }

    private boolean checkAnswer() {
        if (!player.matchPlayerAndBridge(bridge)) {
            return false;
        }
        return true;
    }

    private void judgeTrue(Result result) {
        result.setGameResult(CORRECT_ANSWER);
        OutputView.printMap(result, player);
    }

    private void judgeFalse(Result result) {
        result.setGameResult(WRONG_ANSWER);
        OutputView.printMap(result, player);
    }

    public void retry(Result result) {
        result.updateNumberOfTrials();
        player.resetPlayer();
        result.resetGameResult();
    }
}
