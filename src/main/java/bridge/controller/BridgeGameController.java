package bridge.controller;

import static bridge.Constants.QUIT_GAME;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Objects;

public class BridgeGameController {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(){
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void executeGame(){
        makeGame();
        startGame();
        endGame();
    }

    private void makeGame() {
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        outputView = new OutputView(bridgeGame);
    }

    private void startGame() {
        while (true) {
            boolean moveResult = bridgeGame.move(inputView.readMoving());
            outputView.printMap();
            if (quitGame(moveResult, bridgeGame) | bridgeGame.checkComplete()) {
                break;
            }
        }
    }

    private void endGame() {
        outputView.printResult();
    }

    private boolean quitGame(boolean moveResult, BridgeGame bridgeGame) {
        boolean gameQuit = false;
        if (!moveResult) {
            gameQuit = Objects.equals(inputView.readGameCommand(), QUIT_GAME);
            if (!gameQuit) {
                bridgeGame.retry();
            }
        }
        return gameQuit;
    }
}