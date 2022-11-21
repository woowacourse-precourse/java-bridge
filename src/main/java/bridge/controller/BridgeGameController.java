package bridge.controller;

import bridge.domain.Player;
import bridge.service.BridgeGame;
import bridge.validation.BridgeSizeValidation;
import bridge.validation.GameCommandValidation;
import bridge.validation.MovingValidation;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.PrintGuideMessage;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private static List<String> bridge = new ArrayList<>();
    private static final List<String> movingChoices = new ArrayList<>();
    private static String gameCommand = "";

    private final BridgeGame game;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public BridgeGameController(BridgeGame game) {
        this.game = game;
    }

    public void run() {
        initGame();
        int bridgeSize = getBridgeSize();
        bridge = game.createBridge(bridgeSize);
        while (!game.isEnd(gameCommand, movingChoices, bridge)) {
            playing();
        }
        printResult(gameCommand);
    }

    public void initGame() {
        PrintGuideMessage.printStartGuide();
        PrintGuideMessage.printBridgeSizeGuide();
    }

    public int getBridgeSize() {
        String bridgeSize = "";
        BridgeSizeValidation validation = new BridgeSizeValidation();
        do {
            bridgeSize = inputView.readBridgeSize();
        } while (validation.isValidate(bridgeSize));
        return Integer.parseInt(bridgeSize);
    }

    public void playing() {
        movingChoices.add(getMoving());
        Player player = new Player(movingChoices);
        printMap(game.move(player, bridge));
        if (game.move(player, bridge).contains(false)) {
            rePlaying();
        }
    }

    public String getMoving() {
        PrintGuideMessage.printMovingGuide();
        String moving = "";
        MovingValidation validation = new MovingValidation();
        do {
            moving = inputView.readMoving();
        } while (validation.isValidate(moving));
        return moving;
    }

    public void printMap(List<Boolean> moveResults) {
        outputView.printMap(movingChoices, moveResults);
    }

    public void rePlaying() {
        movingChoices.remove(movingChoices.size() - 1);
        gameCommand = getGameCommand();
        if (game.retry(gameCommand)) {
            playing();
        }
    }

    public String getGameCommand() {
        PrintGuideMessage.printCommandGuide();
        String gameCommand = "";
        GameCommandValidation validation = new GameCommandValidation();
        do {
            gameCommand = inputView.readGameCommand();
        } while (validation.isValidate(gameCommand));
        return gameCommand;
    }

    public void printResult(String gameCommand) {
        PrintGuideMessage.printResultGuide();
        printMap(game.move(new Player(movingChoices), bridge));
        String successOrNot = game.getSuccessOrNot(gameCommand, movingChoices, bridge);
        int attempts = game.getAttempts();
        outputView.printResult(successOrNot, attempts);
    }
}