package bridge.controller;

import bridge.service.BridgeGame;
import bridge.validation.BridgeSizeValidation;
import bridge.validation.MovingValidation;
import bridge.view.InputView;
import bridge.view.PrintGuideMessage;
import java.util.List;

public class BridgeGameController {
    private final BridgeGame game;

    private InputView inputView;
    private BridgeSizeValidation bridgeSizeValidation;
    private MovingValidation movingValidation;

    public BridgeGameController(BridgeGame game) {
        this.game = game;
    }

    public void startGame() {
        int bridgeSize = getBridgeSize();
        List<String> bridge = game.createBridge(bridgeSize);
        List<String> movingChoices = game.createMovingChoices(getMoving());
    }

    public int getBridgeSize() {
        PrintGuideMessage.printStartGuide();
        PrintGuideMessage.printBridgeSizeGuide();
        String input = inputView.readBridgeSize();
        bridgeSizeValidation.isValidate(input);
        return Integer.parseInt(input);
    }

    public String getMoving() {
        PrintGuideMessage.printMovingGuide();
        String input = inputView.readMoving();
        movingValidation.isValidate(input);
        return input;
    }

    public void printMap() {
    }

    public void getGameCommand() {
    }

    public void printResult() {
    }
}