package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeGameResult;
import bridge.utils.InputService;
import bridge.view.OutputView;

public class GamePlayController {
    private final BridgeGame bridgeGame;
    private final int bridgeSize;

    private boolean gameProgress = true;
    private boolean isAllAnswer = false;
    private int gameTryCount = 0;

    public GamePlayController(BridgeGame bridgeGame, int bridgeSize) {
        this.bridgeGame = bridgeGame;
        this.bridgeSize = bridgeSize;
    }

    public void startGame() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult(bridgeSize);
        while (gameProgress && !isAllAnswer) {
            bridgeGameResult.clearResult();
            gameTryCount++;
            progressOneLife(bridgeGameResult);
        }
        showFinalResult(bridgeGameResult.getFinalResult(isAllAnswer, gameTryCount));
    }


    private void progressOneLife(BridgeGameResult bridgeGameResult) {
        int moveIndex = 0;
        boolean isPlay = true;
        while (isPlay && !isAllAnswer) {
            isPlay = progressPlayerMove(moveIndex++, bridgeGameResult);
            isAllAnswer = bridgeGameResult.isGameSuccess();
        }
    }

    private boolean progressPlayerMove(int moveIndex, BridgeGameResult bridgeGameResult) {
        boolean isPossibleMove = bridgeGame.move(moveIndex, InputService.getInputService().inputPlayerMoving(), bridgeGameResult);
        OutputView.getOutputView().printMap(bridgeGameResult.getCurrentResult());
        if (!isPossibleMove) {
            askReplay();
        }
        return isPossibleMove;
    }

    private void askReplay() {
        String gameCommand = InputService.getInputService().inputRetryCommand();
        if (bridgeGame.retry(gameCommand)) {
            return;
        }
        gameProgress = false;
    }

    private void showFinalResult(StringBuffer result) {
        OutputView.getOutputView().printResult(result);
    }
}