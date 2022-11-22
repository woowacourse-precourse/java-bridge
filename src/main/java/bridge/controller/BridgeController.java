package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void playBridge() {
        this.newGame(new ArrayList<>(bridgeMaker.makeBridge(inputView.readBridgeSize())));
    }

    public void newGame(List<String> bridge) {
        bridgeGame.setBridge(bridge);
        do {
            bridgeGame.retry();
            this.newRound();
        } while (this.continueGame());
        outputView.printResult(
                this.currentBridge(), bridgeGame.getGameResult(), bridgeGame.getGameCount());
    }

    public void newRound() {
        do {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(this.currentBridge(), bridgeGame.getGameResult());
        } while (this.continueRound());
    }


    public boolean continueRound() {
        return bridgeGame.getGameResult()
                && (bridgeGame.getCurrentPosition() < bridgeGame.getBridge().size());
    }

    public boolean continueGame() {
        return !bridgeGame.getGameResult() && inputView.readGameCommand().equals("R");
    }

    public List<String> currentBridge() {
        int curr = bridgeGame.getCurrentPosition();
        return new ArrayList<>(bridgeGame.getBridge().subList(0, curr));
    }
}
