package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private Bridge bridge;
    private BridgeGame bridgeGame;

    public int getBridgeSize() {
        outputView.printRequestBridgeSize();
        return inputView.readBridgeSize();
    }

    public void setGame(int size) {
        bridge = new Bridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    public String requestMovingPoint() {
        outputView.printRequestMove();
        return inputView.readMoving();
    }

    public boolean requestRetry() {
        outputView.printRequestGameCommand();
        return inputView.readGameCommand();
    }

    public boolean bridgeRound() {
        String movePlace = requestMovingPoint();
        boolean passable = bridgeGame.move(movePlace, bridge);

        return !bridgeGame.getComplete() && passable;
    }

    public void bridgeGame(){
        while (bridgeRound()) {
            outputView.printMap(bridgeGame.getMark(), true);
        }
    }

    private void playGame() {
        do {
            bridgeGame.retry();
            bridgeGame();
            outputView.printMap(bridgeGame.getMark(), bridgeGame.getComplete());
        } while (!bridgeGame.getComplete() && requestRetry());
    }

    public void start() {
        outputView.printIntro();
        setGame(getBridgeSize());
        playGame();
        outputView.printResult(bridgeGame);
    }
}
