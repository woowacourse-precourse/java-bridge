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
        int bridgeSize = getBridgeSize();
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeList);
        start(bridgeGame);
    }

    private int getBridgeSize() {
        try {
            outputView.printInputBridgeLength();
            return inputView.readBridgeSize();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }

    public void start(BridgeGame bridgeGame) {

        StringBuilder upperBridge = new StringBuilder();
        StringBuilder lowerBridge = new StringBuilder();
        Bridge bridge = new Bridge(upperBridge, lowerBridge);

        playGame(bridgeGame, bridge);
    }

    private void playGame(BridgeGame bridgeGame, Bridge bridge) {
        do {
            String inputCommand = getCommand();
            int index = bridgeGame.getIndex();
            if (index == 0 && checkInitMoveBridge(bridgeGame, bridge, inputCommand)) return;
            if (index != 0 && checkMoveBridge(bridgeGame, bridge, inputCommand)) return;
        } while (!checkBridgeIndex(bridgeGame));

        gameEnd(bridge);
    }

    private String getCommand() {
        try {
            outputView.printSelectMove();
            return inputView.readMoving();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getCommand();
        }
    }

    private boolean checkMoveBridge(BridgeGame bridgeGame, Bridge bridge, String inputMove) {
        if (bridgeGame.moveBridge(bridgeGame, inputMove, bridge)) {
            outputView.printMap(bridge);
            return false;
        }
        outputView.printMap(bridge);
        bridgeGame.initIndex();

        return retry(bridgeGame);
    }

    private boolean checkInitMoveBridge(BridgeGame bridgeGame, Bridge bridge, String inputMove) {
        if (bridgeGame.moveBridgeInit(bridgeGame, inputMove, bridge)) {
            outputView.printMap(bridge);
            return false;
        }
        outputView.printMap(bridge);
        bridgeGame.initIndex();
        return retry(bridgeGame);
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
        try {
            outputView.printSelectRetry();
            String retryOrQuit = inputView.readGameCommand();
            if(bridgeGame.checkRetry(retryOrQuit)) {
                user.addTryCount();
                start(bridgeGame);
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retry(bridgeGame);
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
