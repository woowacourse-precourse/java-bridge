package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.Answer;
import bridge.domain.Bridge;
import bridge.domain.BridgeDirection;
import bridge.domain.BridgeResult;
import bridge.domain.GameCommand;
import bridge.domain.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void run() {
        outputView.printStart();
        bridgeGame = generateBridgeGame();
        BridgeResult result = play();
        GameStatus status = bridgeGame.getStatus();
        int tryCount = bridgeGame.getTryCount();
        outputView.printResult(result, status, tryCount);
    }

    private BridgeResult play() {
        BridgeResult bridgeResult = new BridgeResult();
        while (bridgeGame.isPlaying()) {
            BridgeDirection direction = readBridgeDirection();
            Answer answer = bridgeGame.move(direction);
            bridgeResult.putResult(direction, answer);
            outputView.printMap(bridgeResult);
            if (bridgeGame.isFail()) {
                retry(bridgeResult);
            }
        }
        return bridgeResult;
    }

    private void retry(BridgeResult bridgeResult) {
        GameCommand command = readGameCommand();
        if (command.isRetry()) {
            bridgeGame.retry();
            bridgeResult.reset();
        }
    }

    private BridgeGame generateBridgeGame() {
        List<String> strings = getBridge();
        Bridge bridge = new Bridge(strings);
        return new BridgeGame(bridge);
    }

    private GameCommand readGameCommand() {
        try {
            String userRetrySelect = inputView.readGameCommand();
            return GameCommand.of(userRetrySelect);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readGameCommand();
        }
    }

    private List<String> getBridge() {
        try {
            int size = inputView.readBridgeSize();
            return bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getBridge();
        }
    }

    private BridgeDirection readBridgeDirection() {
        try {
            String input = inputView.readMoving();
            return BridgeDirection.wordToDirection(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readBridgeDirection();
        }
    }
}
