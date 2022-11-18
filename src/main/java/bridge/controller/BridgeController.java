package bridge.controller;

import bridge.*;

public class BridgeController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGame bridgeGame;

    public void startGame() {
        outputView.printStartingPhrase();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        //System.out.println(bridgeGame.getBridge());
        startMove();
    }

    public void startMove() {
        while (true) {
            if (bridgeGame.move(inputView.readMoving()) == false) {
                break;
            }
            if(bridgeGame.isEndOfBridge() == true){
                break;
            }
        }
    }
}
