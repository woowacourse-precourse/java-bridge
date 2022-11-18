package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.model.Bridge;
import bridge.model.User;
import bridge.util.BridgeNumberGenerator;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    User user = new User(0, false);
    StringBuilder upperBridge = new StringBuilder();
    StringBuilder lowerBridge = new StringBuilder();

    public void initGame() {
        outputView.printStartGame();
        outputView.printInputBridgeLength();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        start(bridgeGame, bridge);
    }
    public void start(BridgeGame bridgeGame, List<String> bridge) {
        outputView.printSelectMove();
        String inputMove = inputView.readMoving();
        int index = bridgeGame.getIndex();
        int bridgeSize = bridge.size();
        Bridge bridge1 = new Bridge(upperBridge, lowerBridge);
        while (index != bridgeSize) {
            index = bridgeGame.getIndex();
            if (index == 0) {
                bridgeGame.moveBridgeInit(bridgeGame, bridge, inputMove, index, bridge1);
            }
            if (index != 0) {
                bridgeGame.moveBridge(bridgeGame, bridge, inputMove, index, bridge1);
            }
        }
    }

    public void retry(BridgeGame bridgeGame) {
        outputView.printSelectRetry();
        String retryOrQuit = inputView.readGameCommand();
        if(bridgeGame.checkRetry(retryOrQuit)) {
            // 다리건너기 메서드 작성 이후 작성
        }
        if(!bridgeGame.checkRetry(retryOrQuit)) {
            boolean success = user.isSuccess();
            int tryCount = user.getTryCount();
            outputView.printResult(success, tryCount);
        }
    }
}
