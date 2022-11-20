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
        User user = new User();
        inputView.printMessage(inputMessage.START_GAME);
        int bridgeSize = inputView.readBridgeSize();
        setBridgeSize(bridgeSize);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        crossBridge(bridge, user);
    }
    public void crossBridge(List<String> bridge, User user) {
        int currentIndex = 0;
        while (true) {
            String direction = inputView.readMoving();
            setDirection(direction);
            boolean isUp = direction.equals(bridge.get(currentIndex));
            String result = bridgeGame.move(direction, bridge.get(currentIndex));
            addResultBridge(isUp, result, user);
            outputView.printMessage(user.toString());
        }
    }
    public void addResultBridge(boolean isUp, String result, User user) {
        if(isUp) {
            user.addUpperBridge(result);
            return;
        }
        user.addLowerBridge(result);
    }

    public void setDirection(String direction) {
        try {
            validator.validateDirection(direction);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            direction = inputView.readMoving();
            setDirection(direction);
        }
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
