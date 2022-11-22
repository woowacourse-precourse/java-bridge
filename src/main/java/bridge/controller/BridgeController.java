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

    public int requestBridgeSize() {
        try {
            outputView.printRequestBridgeSize();
            return inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            return requestBridgeSize();
        }
    }

    public void setGame(int size) {
        bridge = new Bridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    public String requestMovingPoint() {
        try {
            outputView.printRequestMove();
            return inputView.readMoving();
        }catch (IllegalArgumentException e){
            return requestMovingPoint();
        }
    }

    public boolean requestRetry() {
        try {
            outputView.printRequestGameCommand();
            return inputView.readGameCommand();
        }catch (IllegalArgumentException e){
            return requestRetry();
        }
    }

    public boolean bridgeRound() {
        String movePlace = requestMovingPoint();
        boolean passable = bridgeGame.move(movePlace, bridge);

        return !bridgeGame.getComplete() && passable;
    }

    public void bridgeGame(){
        while (bridgeRound()) {
            outputView.printMap(bridgeGame,true);
        }
    }

    private void playGame() {
        do {
            bridgeGame.retry();
            bridgeGame();
            outputView.printMap(bridgeGame,bridgeGame.getComplete());
        } while (isGameOver());
    }

    public boolean isGameOver(){
        return !bridgeGame.getComplete() && requestRetry();
    }

    public void start() {
        outputView.printIntro();
        setGame(requestBridgeSize());
        playGame();
        outputView.printResult(bridgeGame);
    }
}
