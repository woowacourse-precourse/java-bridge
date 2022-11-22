package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.GameResultDto;
import bridge.view.OutputView;

public class GameController {
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public GameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        do {
            runRound();
        } while (canContinueGame());

        printResult();
    }

    private void runRound() {
        String moving;
        do {
            moving = inputController.selectMoving();
            bridgeGame.move(moving);
            outputView.printMap(bridgeGame.drawPassingSpace());
        } while (canContinueRound());
    }

    private boolean canContinueRound() {
        return bridgeGame.selectRightSpace() && !bridgeGame.isSuccessCrossingBridge();
    }

    private boolean canContinueGame() {
        if (bridgeGame.isSuccessCrossingBridge()) {
            return false;
        }

        String selectRetrying = inputController.selectRetryGame();
        return bridgeGame.retry(selectRetrying);
    }

    private void printResult() {
        GameResultDto gameResult = bridgeGame.getGameResult();
        outputView.printResult(gameResult);
    }
}