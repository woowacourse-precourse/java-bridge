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

    public void setGame(int size){
        bridge = new Bridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    public String requestMovingPoint(){
        outputView.printRequestMove();
        return inputView.readMoving();
    }

    public boolean requestRetry(){
        outputView.printRequestGameCommand();
        return inputView.readGameCommand();
    }

    public boolean bridgeGame(){
        String movePlace = requestMovingPoint();
        boolean passable = bridgeGame.move(movePlace, bridge);

        return !bridgeGame.getComplete() && passable;
    }

    public void start() {
        outputView.printIntro();
        int size = getBridgeSize();
        setGame(size);

        do{
            bridgeGame.retry();

            while (bridgeGame()){
                outputView.printMap(bridgeGame.getMark(), true);
            };  // O 면 반복
            outputView.printMap(bridgeGame.getMark(), bridgeGame.getComplete());
            // 다 건너면 탈출

        }while (!bridgeGame.getComplete() && requestRetry());
        outputView.printResult(bridgeGame ,bridgeGame.getComplete());
    }
}
