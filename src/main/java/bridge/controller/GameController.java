package bridge.controller;

import bridge.constants.InputMessage;
import bridge.service.BridgeGame;
import bridge.service.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputMessage inputMessage = new InputMessage();
    private final Validator validator = new Validator();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void startGame() {
        inputView.printMessage(inputMessage.START_GAME);
        List<String> bridge = bridgeGame.makeResultBridge(setBridgeSize(inputView.readBridgeSize()));
        crossBridge(bridge);
        while (bridgeGame.userRestartGame()) {
            crossBridge(bridge);
        }
    }
    public void crossBridge(List<String> bridge) {
        bridgeGame.turnOffFlag();
        for(int currentIndex = 0; currentIndex < bridge.size(); currentIndex++) {
            if(makeResult(bridge, currentIndex).equals("X")) {
                askRestartOrEnd();
                return;
            }
        }
        outputView.printResult(bridgeGame.userBridge(), false, bridgeGame.userRetryCount() + "");
    }

    public String makeResult(List<String> bridge, int currentIndex) {
        String result = bridgeGame.move(bridge.get(currentIndex), setDirection(inputView.readMoving()));
        outputView.printMap(bridgeGame.userBridge());
        return result;
    }
    public void askRestartOrEnd() {
        List<String> userResult = bridgeGame.calculateRestartOrEnd(setRetryOrQuit(inputView.readGameCommand()));
        if(userResult == null) {
            return;
        }
        outputView.printResult(userResult.get(0), true, userResult.get(1));
    }

    private String setRetryOrQuit(String retryOrQuit) {
        try {
            validator.validateRetryOfQuit(retryOrQuit);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            retryOrQuit = inputView.readGameCommand();
            setRetryOrQuit(retryOrQuit);
        }
        return retryOrQuit;
    }

    public String setDirection(String direction) {
        try {
            validator.validateDirection(direction);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            direction = inputView.readMoving();
            setDirection(direction);
        }
        return direction;
    }

    public int setBridgeSize(int bridgeSize) {
        try {
            validator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            bridgeSize = inputView.readBridgeSize();
            setBridgeSize(bridgeSize);
        }
        return bridgeSize;
    }
}