package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private static final int BUILDER_INITIALIZE = 0;
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private static final boolean CLEAR = true;
    private static final boolean FAILED = false;
    BridgeGame bridgeGame;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public void startGame() {
        outputView.printGameStart();
        int size = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    public void movePlayer() {
        boolean isCorrect = true;
        boolean isClear = false;
        while (isCorrect && !isClear){
            String selection = inputView.readMoving();
            isCorrect = bridgeGame.move(selection);
            isClear = bridgeGame.isClear();
            outputView.printMap(selection, isCorrect);
        }
        checkStatus(isClear);
    }

    private void restartGame() {
        outputView.upsideBridge.setLength(BUILDER_INITIALIZE);
        outputView.downsideBridge.setLength(BUILDER_INITIALIZE);
        bridgeGame.retry();
        movePlayer();
    }

    private void checkStatus(boolean isClear) {
        if (isClear) {
            outputView.printResult(CLEAR);
            return;
        }
        askRestart();
    }

    private void askRestart() {
        String restart = inputView.readGameCommand();
        if (restart.equals(RESTART)) {
            restartGame();
            return;
        }
        outputView.printResult(FAILED);
    }
}
