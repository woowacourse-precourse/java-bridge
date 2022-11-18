package bridge.controller;

import static bridge.Constants.COMPLETE;
import static bridge.Constants.RESTART_GAME;

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

    public void makeGame() {
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        outputView = new OutputView(bridgeGame);
    }

    public void startGame() {
        while (true) {
            boolean moveResult = bridgeGame.move(inputView.readMoving());
            outputView.printMap();
            if (finishGame(moveResult, bridgeGame) | (Objects.equals(bridgeGame.checkCompleteOrFail(), COMPLETE))) {
                break;
            }
        }
    }

    public void endGame() {
        outputView.printResult();
    }

    private boolean finishGame(boolean moveResult, BridgeGame bridgeGame) {
        if (!moveResult) {
            String s = inputView.readGameCommand();
            if (Objects.equals(s, RESTART_GAME)) {
                bridgeGame.retry();
                return false;
            }
            return true;
        }
        return false;
    }
}