package bridge.controller;

import bridge.domain.Player;
import bridge.service.BridgeGame;
import bridge.validation.BridgeSizeValidation;
import bridge.validation.GameCommandValidation;
import bridge.validation.MovingValidation;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.PrintGuideMessage;
import bridge.view.enums.MapType;
import java.util.List;

public class BridgeGameController {
    private final BridgeGame game;

    public BridgeGameController(BridgeGame game) {
        this.game = game;
    }

    public void startGame() {
        int bridgeSize = getBridgeSize();
        List<String> bridge = game.createBridge(bridgeSize);
        do {
            List<String> movingChoices = game.createMovingChoices(getMoving());
            String move = game.move(new Player(movingChoices), bridge);
            printMap(new Player(movingChoices), bridge, move);
            if (move.equals(MapType.CAN_NOT_STEP.getType())) {
                break;
            }
        } while (game.retry(getGameCommand()));
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

    public String getGameCommand() {
        PrintGuideMessage.printCommandGuide();
        String input = new InputView().readGameCommand();
        GameCommandValidation validation = new GameCommandValidation();
        validation.isValidate(input);
        return input;
    }

    public void printResult(String gameCommand, List<String> movingChoices, List<String> bridge) {
        PrintGuideMessage.printResultGuide();
        String successOrNot = game.getSuccessOrNot(gameCommand, movingChoices, bridge);
        int attempts = game.getAttempts();
        OutputView outputView = new OutputView();
        outputView.printResult(successOrNot, attempts);
    }
}