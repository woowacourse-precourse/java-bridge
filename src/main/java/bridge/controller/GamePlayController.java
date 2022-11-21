package bridge.controller;

import bridge.factory.ViewFactory;
import bridge.model.BridgeGame;
import bridge.model.BridgeGameResult;
import bridge.view.InputView;

public class GamePlayController {
    InputView inputView = new InputView();
    private final ViewFactory viewFactory;
    private final BridgeGame bridgeGame;
    private final BridgeGameResult bridgeGameResult;
    private boolean gameProgress = true;

    public GamePlayController(BridgeGame bridgeGame, BridgeGameResult bridgeGameResult) {
        this.bridgeGame = bridgeGame;
        this.bridgeGameResult = bridgeGameResult;
        this.viewFactory = new ViewFactory();
    }

    public void startGame() {
        bridgeGameResult.resetResult();
        int moveIndex = 0;
        while (gameProgress) {
            progressPlayerMove(moveIndex);
            moveIndex++;
            isGameClear(moveIndex);
        }
        showFinalResult(bridgeGameResult.getFinalResult(moveIndex, "성공"));
    }

    private void showCurrentResult(int index) {
        viewFactory.createOutputView().printMap(bridgeGameResult.getCurrentResult(index));
    }

    private void progressPlayerMove(int moveIndex) {
        boolean isPossibleMove = bridgeGame.move(moveIndex++, inputView.readMoving(), bridgeGameResult);
        showCurrentResult(moveIndex);
        if (!isPossibleMove) {
            askReplay(moveIndex);
        }
    }

    private void askReplay(int moveIndex) {
        String gameCommand = inputView.readGameCommand();
        if (bridgeGame.retry(gameCommand)) {
            startGame();
            return;
        }
        showFinalResult(bridgeGameResult.getFinalResult(moveIndex, "실패"));
        gameProgress = false;
    }

    private void isGameClear(int moveIndex) {
        if (bridgeGame.isAllStep(moveIndex)) {
            gameProgress = false;
        }
    }

    private void showFinalResult(StringBuffer result) {
        viewFactory.createOutputView().printResult(result);
    }
}
