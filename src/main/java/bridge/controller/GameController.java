package bridge.controller;

import bridge.constants.InputMessage;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.User;
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
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final BridgeGame bridgeGame = new BridgeGame();

    public void startGame() {
        User user = new User(1);
        inputView.printMessage(inputMessage.START_GAME);
        int bridgeSize = inputView.readBridgeSize();
        setBridgeSize(bridgeSize);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        crossBridge(bridge, user);
        while (user.isRestartGame()) {
            user = new User(user.getRetryCount());
            crossBridge(bridge, user);
        }
    }
    public void crossBridge(List<String> bridge, User user) {
        int currentIndex = 0;
        while (true) {
            String direction = setDirection(inputView.readMoving());
            String result = bridgeGame.move(direction, bridge.get(currentIndex));
            addResultBridge(direction.equals("U"), result, user);
            currentIndex++;
            outputView.printMap(user.toString());
            if(result.equals("X")) {
                askRestartOrEnd(user.toString(), user.getRetryCount(), user);
                return;
            }
            if(currentIndex == bridge.size()) {
                outputView.printResult(user.toString(), false, user.getRetryCount());
                return;
            }
        }
    }
    public void printStatusBridge(String userBridge) {
        outputView.printMap(userBridge);
    }
    public void askRestartOrEnd(String userBridge, int tryCount, User user) {
        String retryOrQuit  = inputView.readGameCommand();
        setRetryOrQuit(retryOrQuit);
        if(retryOrQuit.equals("R")) {
            user.plusRetryCount();
            user.changeisRestartGame();
            return;
        }
        outputView.printResult(userBridge, true, tryCount);
    }

    private void setRetryOrQuit(String retryOrQuit) {
        try {
            validator.validateRetryOfQuit(retryOrQuit);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            retryOrQuit = inputView.readMoving();
            setDirection(retryOrQuit);
        }
    }

    public void addResultBridge(boolean isUp, String result, User user) {
        if(isUp) {
            user.addUpperBridge(result);
            return;
        }
        user.addLowerBridge(result);
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
    public void setBridgeSize(int bridgeSize) {
        try {
            validator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            bridgeSize = inputView.readBridgeSize();
            setBridgeSize(bridgeSize);
        }
    }
}
