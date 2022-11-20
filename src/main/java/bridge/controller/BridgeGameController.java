package bridge.controller;

import bridge.service.BridgeGame;
import bridge.validation.BridgeSizeValidation;
import bridge.view.InputView;
import bridge.view.PrintGuideMessage;
import java.util.List;

public class BridgeGameController {
    private final BridgeGame game;
    private InputView inputView;
    private BridgeSizeValidation bridgeSizeValidation;

    public BridgeGameController(BridgeGame game) {
        this.game = game;
    }

    public void startGame() {
        int bridgeSize = getBridgeSize();
        List<String> bridge = game.createBridge(bridgeSize);
    }

    public int getBridgeSize() {
        PrintGuideMessage.printStartGuide();
        PrintGuideMessage.printBridgeSizeGuide();
        String input = inputView.readBridgeSize();
        bridgeSizeValidation.isValidate(input);
        return Integer.parseInt(input);
    }

    public void getMoving() {
    }

    public void printMap() {
    }

    public void getGameCommand() {
    }

    public void printResult() {
    }
}