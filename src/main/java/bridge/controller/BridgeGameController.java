package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.FinalGameResult;
import bridge.domain.GameCommand;
import bridge.domain.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private boolean isFinished = false;
    private GameResult gameResult;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        makeBridgeGame();
        while (true) {
            progressGameStage();
            checksGameEnd();
            if(isFinished) {
                completeGame();
                break;
            }
        }
    }

    public void makeBridgeGame() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize, new BridgeRandomNumberGenerator());
    }

    public void progressGameStage() {
        String userMove = inputView.readMoving();
        GameResult gameResult = bridgeGame.move(userMove);
        this.gameResult = gameResult;
        outputView.printMap(gameResult);
    }

    public void checksGameEnd() {
        if(bridgeGame.isSuccess()) {
            isFinished = true;
        }
        if(bridgeGame.isEnd()) {
            String gameCommand = inputView.readGameCommand();
            retryOrEnd(gameCommand);
        }
    }

    public void retryOrEnd(String gameCommand) {
        GameCommand userCommand = GameCommand.makeGameCommand(gameCommand);
        if(userCommand.equals(GameCommand.RESTART)) {
            bridgeGame.retry();
            return;
        }
        isFinished = true;
    }

    public void completeGame() {
        FinalGameResult finalGameResult = FinalGameResult.makeFinalGameResult(bridgeGame.isSuccess());
        outputView.printResult(finalGameResult, bridgeGame.getTotalTryCount(), gameResult);
    }
}
