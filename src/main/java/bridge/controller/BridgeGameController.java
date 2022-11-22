package bridge.controller;

import static bridge.Constants.QUIT_GAME;
import static bridge.view.InputView.readBridgeSize;
import static bridge.view.InputView.readGameCommand;
import static bridge.view.InputView.readMoving;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.OutputView;
import java.util.Objects;

public class BridgeGameController {
    private final BridgeMaker bridgeMaker;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(){
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void executeGame(){
        makeGame();
        startGame();
        endGame();
    }

    private void makeGame() {
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(readBridgeSize()));
        outputView = new OutputView(bridgeGame);
    }

    private void startGame() {
        while (true) {
            boolean moveResult = bridgeGame.move(readMoving());
            outputView.printMap();
            if (quitGame(moveResult, bridgeGame) | bridgeGame.checkComplete()) {
                break;
            }
        }
    }

    private void endGame() {
        outputView.printResult();
    }

    private boolean quitGame(final boolean moveResult, final BridgeGame bridgeGame) {
        boolean gameQuit = false;
        if (!moveResult) {
            gameQuit = Objects.equals(readGameCommand(), QUIT_GAME);
            if (!gameQuit) {
                bridgeGame.retry();
            }
        }
        return gameQuit;
    }
}