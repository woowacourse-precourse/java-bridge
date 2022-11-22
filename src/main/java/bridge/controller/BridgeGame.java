package bridge.controller;

import bridge.service.BridgeGenerateService;
import bridge.domain.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGame {
    private static int bridgeSize;
    private static int position;
    private static int trialCount = 0;
    private static boolean onMovableCompartment = true;
    private static boolean isTryingToClearGame = true;
    private static List<String> bridge;

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeGenerateService bridgeGenerateService;

    public BridgeGame() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.bridgeGenerateService = new BridgeGenerateService();
    }

    public void Run() {
        outputView.printGameStartNotice();
        bridge = generateBridge();
        while (isTryingToClearGame) {
            trialCount++;
            playGame();
        }
    }

    private List<String> generateBridge() {
        outputView.printBridgeSizeInputNotice();
        bridgeSize = inputView.readBridgeSize();
        System.out.println();
        return bridgeGenerateService.generateBridgeBySize(bridgeSize);
    }

    private void playGame() {
        moveUntilFailOrSuccess();
        if (onMovableCompartment) {
            quit();
            return;
        }
        String gameCommand = askGameCommand();
        if (gameCommand.equals("Q")) {
            quit();
        }
    }

    private void moveUntilFailOrSuccess() {
        initializeGame();

        while (isPlaying()) {
            move();
        }
    }

    private boolean isPlaying() {
        return onMovableCompartment && position < bridgeSize;
    }

    private void initializeGame() {
        position = 0;
        onMovableCompartment = true;
        outputView.initializeMap();
    }

    private void move() {
        outputView.printMovingInputNotice();
        String moving = inputView.readMoving();
        onMovableCompartment = bridge.get(position++).equals(moving);
        outputView.printMap(position, moving, onMovableCompartment);
    }

    private String askGameCommand() {
        outputView.printGameCommandInputNotice();
        return inputView.readGameCommand();
    }

    private void quit() {
        outputView.printResult(onMovableCompartment, trialCount);
        isTryingToClearGame = false;
    }

    private boolean retry(String gameCommand) {
        return gameCommand.equals(GameCommand.RESTART.getCommand());
    }
}
