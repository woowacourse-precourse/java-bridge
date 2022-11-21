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
        start(bridgeGame);
    }

    public void start(BridgeGame bridgeGame) {

        StringBuilder upperBridge = new StringBuilder();
        StringBuilder lowerBridge = new StringBuilder();
        Bridge bridge = new Bridge(upperBridge, lowerBridge);

        playGame(bridgeGame, bridge);
    }

    private void playGame(BridgeGame bridgeGame, Bridge bridge) {
        do {
            outputView.printSelectMove();
            String inputMove = inputView.readMoving();
            int index = bridgeGame.getIndex();
            if (index == 0 && checkInitMoveBridge(bridgeGame, bridge, inputMove)) return;
            if (index != 0 && checkMoveBridge(bridgeGame, bridge, inputMove)) return;
        } while (!checkBridgeIndex(bridgeGame));
        
        gameEnd(bridge);
    }

    private boolean checkMoveBridge(BridgeGame bridgeGame, Bridge bridge, String inputMove) {
        if (bridgeGame.moveBridge(bridgeGame, inputMove, bridge)) {
            outputView.printMap(bridge);
        } else {
            outputView.printMap(bridge);
            bridgeGame.initIndex();

            if (retry(bridgeGame)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkInitMoveBridge(BridgeGame bridgeGame, Bridge bridge, String inputMove) {
        if (bridgeGame.moveBridgeInit(bridgeGame, inputMove, bridge)) {
            outputView.printMap(bridge);
        } else {
            outputView.printMap(bridge);
            bridgeGame.initIndex();
            if (retry(bridgeGame)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkBridgeIndex(BridgeGame bridgeGame) {
        List<String> bridgeList = bridgeGame.getBridge();
        int bridgeSize = bridgeList.size();
        int curIndex = bridgeGame.getIndex();
        if(curIndex == bridgeSize) {
            user.checkSuccess();
            return true;
        }
        return false;
    }

    public boolean retry(BridgeGame bridgeGame) {
        boolean flag = false;
        outputView.printSelectRetry();
        String retryOrQuit = inputView.readGameCommand();
        if(bridgeGame.checkRetry(retryOrQuit)) {
            user.addTryCount();
            start(bridgeGame);
        }
        return !flag;
    }

    private void gameEnd(Bridge bridge) {
        boolean success = user.isSuccess();
        int tryCount = user.getTryCount();
        outputView.printResultMessage();
        outputView.printMap(bridge);
        outputView.printResult(success, tryCount);
    }
}
