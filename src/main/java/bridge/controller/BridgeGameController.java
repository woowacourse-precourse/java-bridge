package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.BridgeGenerateService;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeGenerateService bridgeGenerateService;

    private static List<String> bridge;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGenerateService = new BridgeGenerateService();
    }

    public void Run() {
        outputView.printGameStartNotice();
        bridge = generateBridge();

        playGame();

        outputView.printResult(bridgeGame.isOnMovableCompartment(), bridgeGame.getTrialCount());
    }

    private List<String> generateBridge() {
        outputView.printBridgeSizeInputNotice();
        return bridgeGenerateService.generateBridgeBySize(inputView.readBridgeSize());
    }

    private void playGame() {
        startNewRound();
        while (bridgeGame.isPlaying(bridge)) {
            crossBridge();
        }
        if (bridgeGame.isOnMovableCompartment()) {
            return;
        }
        if (askGameCommand().equals("R")) {
            retry();
        }
    }

    private void startNewRound() {
        bridgeGame.initializeRound();
        outputView.initializeMap();
    }

    private void crossBridge() {
        String moving = askMoving();
        bridgeGame.move(moving, bridge);
        showMap(moving);
    }

    private String askMoving() {
        outputView.printMovingInputNotice();
        return inputView.readMoving();
    }

    private void showMap(String moving) {
        outputView.printMap(bridgeGame.getPosition(), moving, bridgeGame.isOnMovableCompartment());
        bridgeGame.addPosition();
    }

    private String askGameCommand() {
        outputView.printGameCommandInputNotice();
        return inputView.readGameCommand();
    }

    public void retry() {
        playGame();
    }
}
