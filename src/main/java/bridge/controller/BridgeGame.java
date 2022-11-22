package bridge.controller;

import bridge.service.BridgeGenerateService;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGame {
    private static int position;
    private static int trialCount;
    private static boolean onMovableCompartment;
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

        trialCount = 0;
        playGame();

        outputView.printResult(onMovableCompartment, trialCount);
    }

    private List<String> generateBridge() {
        outputView.printBridgeSizeInputNotice();
        return bridgeGenerateService.generateBridgeBySize(inputView.readBridgeSize());
    }

    private void playGame() {
        trialCount++;

        moveUntilFailOrSuccess();
        if (onMovableCompartment) {
            return;
        }
        if (askGameCommand().equals("R")) {
            retry();
        }
    }

    private void moveUntilFailOrSuccess() {
        initializeGame();

        while (isPlaying()) {
            move();
        }
    }

    private boolean isPlaying() {
        return onMovableCompartment && position < bridge.size();
    }

    private void initializeGame() {
        position = 0;
        onMovableCompartment = true;
        outputView.initializeMap();
    }

    private void move() {
        outputView.printMovingInputNotice();
        String moving = inputView.readMoving();
        onMovableCompartment = bridge.get(position).equals(moving);
        outputView.printMap(position++, moving, onMovableCompartment);
    }

    private String askGameCommand() {
        outputView.printGameCommandInputNotice();
        return inputView.readGameCommand();
    }

    private void retry() {
        playGame();
    }
}
