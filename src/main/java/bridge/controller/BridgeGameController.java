package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private List<String> correctBridge;
    private int tryCount = 0;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        try {
            startBrideGame();
            crossBridge();
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printError(illegalArgumentException.getMessage());
        }
    }

    private void startBrideGame() {
        outputView.printStartMessage();
        correctBridge = makeBridge();
    }

    private List<String> makeBridge() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private void crossBridge() {
        BridgeGame bridgeGame = gameInit();
        for (String bridgeValue : correctBridge) {
            boolean correctAnswerCheck = bridgeGame.move(inputView.readMoving(), bridgeValue);
            outputView.printMap(bridgeGame.getBridges());
            if (correctAnswerCheck != true) {
                chooseRetryGameOrEndGame(bridgeGame);
                return;
            }
        }
        endGame(bridgeGame);
    }
    private void chooseRetryGameOrEndGame(BridgeGame bridgeGame) {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            crossBridge();
            return;
        }
        endGame(bridgeGame);
    }

    private void endGame(BridgeGame bridgeGame) {
        outputView.printResult(bridgeGame.getBridges(), bridgeGame.getGameResult(), tryCount);
    }

    private BridgeGame gameInit() {
        tryCount += 1;
        return new BridgeGame();
    }
}
