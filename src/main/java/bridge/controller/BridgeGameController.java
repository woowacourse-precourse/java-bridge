package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.controller.cosntant.GameCommand;
import bridge.domain.constant.BridgeDirection;
import bridge.domain.model.BridgeGame;
import bridge.domain.model.GameProgress;
import bridge.domain.model.GameState;
import bridge.domain.model.Player;
import bridge.view.OutputView;

public class BridgeGameController {
    InputController inputController = new InputController();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame;
    Player player = new Player();
    GameState gameState = new GameState();
    GameProgress gameProgress = new GameProgress();
    public BridgeGameController(BridgeNumberGenerator bridgeNumberGenerator){
        this.bridgeGame = new BridgeGame(bridgeNumberGenerator);
        gameState.initialize();
    }

    public void makeBridge() {
        int bridgeSize = inputController.checkBridgeSize();
        bridgeGame.constructBridge(bridgeSize);
        gameProgress.updateBridgeLength(bridgeSize);
    }

    public void crossBridge() {
        String moving = inputController.checkMoving();

        player.saveDirection(moving);

        boolean currentGameState = bridgeGame.move(player.notifyDirection(), gameProgress.noticeTrial());
        gameState.updateGameState(currentGameState);
        gameProgress.updateTrial();
        printCurrentMap(player.getCurrentDirection(), gameState.getGameState(), gameProgress.isFirstTrial());
    }

    public void printCurrentMap(BridgeDirection bridgeDirection, boolean gameState, boolean isFirstTrial){
        String report = bridgeGame.makeReport(gameState, bridgeDirection, isFirstTrial);
        outputView.printMap(report);
    }


    public void playSingleGame() {

        gameState.initialize();
        gameProgress.initialize();
        while (gameState.isSingleGameEnd(gameProgress.isGameContinued())) {
            crossBridge();
        }
        gameProgress.updateTotalCount();
    }

    public void retryProcess() {
        if (!gameState.getGameState()) {
            boolean wantRetry=askRetry();
            gameState.updateRestartState(wantRetry);
            if(wantRetry){
                bridgeGame.deleteRecord();
            }
        }
    }

    public boolean askRetry() {
        String gameCommand = inputController.checkGameCommand();
        return GameCommand.transformToAction(gameCommand);
    }

    public void printFinalResult() {
        String report = bridgeGame.getFinalResult();
        outputView.printMapResult(report);
        outputView.printGameResult(gameState.getWordState());
        outputView.printTotalTrial(gameProgress.getTotalTrial());
    }

    public void start() {
        outputView.printStartMessage();
        makeBridge();
        do {
            playSingleGame();
            retryProcess();
        } while (gameState.isGameContinue());
        printFinalResult();
    }
}
