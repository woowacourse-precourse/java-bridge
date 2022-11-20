package bridge.controller;

import bridge.domain.Player;
import bridge.service.BridgeGame;
import bridge.validation.BridgeSizeValidation;
import bridge.validation.MovingValidation;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.PrintGuideMessage;
import java.util.List;

public class BridgeGameController {
    private final BridgeGame game;

    public BridgeGameController(BridgeGame game) {
        this.game = game;
    }

    public void startGame() {
        int bridgeSize = getBridgeSize();
        List<String> bridge = game.createBridge(bridgeSize);
        List<String> movingChoices = game.createMovingChoices(getMoving());
        String move = game.move(new Player(movingChoices), bridge);
        printMap(new Player(movingChoices), bridge, move);
    }

    public int getBridgeSize() {
        PrintGuideMessage.printStartGuide();
        PrintGuideMessage.printBridgeSizeGuide();
        String input = new InputView().readBridgeSize();
        BridgeSizeValidation validation = new BridgeSizeValidation();
        validation.isValidate(input);
        return Integer.parseInt(input);
    }

    public String getMoving() {
        PrintGuideMessage.printMovingGuide();
        String input = new InputView().readMoving();
        MovingValidation validation = new MovingValidation();
        validation.isValidate(input);
        return input;
    }

    public void printMap(Player player, List<String> bridge, String move) {
        OutputView outputView = new OutputView();
        outputView.printMap(player, bridge, move);
    }

    public void getGameCommand() {
    }

    public void printResult() {
    }
}