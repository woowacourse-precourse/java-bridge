package bridge.service;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeService {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();


    public void startBridgeGame() {
        outputView.printStartMessage();
        outputView.printInputBridgeSizeMessage();

        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.setBridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void moveBridge() {

        outputView.printInputMoveBridgeMessage();
        String userMove = inputView.readMoving();
        bridgeGame.move(userMove);
        outputView.printMap(bridgeGame.getUser(), bridgeGame.getBridge());
    }


}
