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
    User user = new User(1, false);

    public void initGame() {
        outputView.printStartGame();
        outputView.printInputBridgeLength();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeList);
        start(bridgeGame, bridgeList);
    }

    public void start(BridgeGame bridgeGame, List<String> bridgeList) {

        StringBuilder upperBridge = new StringBuilder();
        StringBuilder lowerBridge = new StringBuilder();

        while (true) {

            outputView.printSelectMove();
            String inputMove = inputView.readMoving();

            System.out.println(bridgeList);

            Bridge bridge = new Bridge(upperBridge, lowerBridge);

            int index = bridgeGame.getIndex();
            if (index == 0) {
                if(bridgeGame.moveBridgeInit(bridgeGame, inputMove, bridge)) {
                    outputView.printMap(bridge);
                }
                else {
                    outputView.printMap(bridge);
                    bridgeGame.initIndex();
                    if(retry(bridgeGame, bridgeList)){
                        break;
                    }
                }
            }
            if (index != 0) {
                if(bridgeGame.moveBridge(bridgeGame, inputMove, bridge)) {
                    outputView.printMap(bridge);
                }
                else {
                    outputView.printMap(bridge);
                    bridgeGame.initIndex();

                    if(retry(bridgeGame, bridgeList)){
                        gameEnd();
                        break;
                    }
                }
            }
            if (checkBridgeIndex(bridgeGame, bridgeList)) break;
        }
    }

    private boolean checkBridgeIndex(BridgeGame bridgeGame, List<String> bridgeList) {
        int bridgeSize = bridgeList.size();
        int curIndex = bridgeGame.getIndex();
        if(curIndex == bridgeSize) {
            user.checkSuccess();
            gameEnd();
            return true;
        }
        return false;
    }

    public boolean retry(BridgeGame bridgeGame, List<String> bridgeList) {
        boolean flag = false;
        outputView.printSelectRetry();
        String retryOrQuit = inputView.readGameCommand();
        if(bridgeGame.checkRetry(retryOrQuit)) {
            user.addTryCount();
            start(bridgeGame, bridgeList);
        }
        return !flag;
    }

    private void gameEnd() {
        boolean success = user.isSuccess();
        int tryCount = user.getTryCount();
        outputView.printResultMessage();
        outputView.printResult(success, tryCount);
    }
}
