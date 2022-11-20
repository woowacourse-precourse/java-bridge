package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.BridgeUnit;
import bridge.domain.Command;
import bridge.domain.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.Command.RETRY;
import static bridge.domain.GameStatus.FAILED;
import static bridge.domain.GameStatus.PLAYING;

public class BridgeApplication {

    private final OutputView outputView;
    private final InputView inputView;

    public BridgeApplication() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        outputView.printStartMessage();
        BridgeGame bridgeGame = initBridgeGame();

        GameStatus status = PLAYING;
        do {
            status = crossBridge(bridgeGame, status);
            status = readGameCommandIfFailed(bridgeGame, status);
        } while (PLAYING.equals(status));
        outputView.printResult(bridgeGame, status);
    }

    private BridgeGame initBridgeGame() {
        try {
            int bridgeSize = readBridgeSize();
            Bridge bridge = initBridge(bridgeSize);
            return new BridgeGame(bridge);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return initBridgeGame();
        }
    }

    private int readBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readBridgeSize();
        }
    }

    private Bridge initBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeRaw = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridgeRaw);
    }

    private GameStatus crossBridge(BridgeGame bridgeGame, GameStatus status) {
        while (PLAYING.equals(status)) {
            BridgeUnit nextUnit = getNextBridgeUnit();

            status = bridgeGame.move(nextUnit);
            outputView.printMap(bridgeGame);
        }
        return status;
    }

    private BridgeUnit getNextBridgeUnit() {
        try {
            String moving = inputView.readMoving();
            return BridgeUnit.from(moving);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getNextBridgeUnit();
        }
    }

    private GameStatus readGameCommandIfFailed(BridgeGame bridgeGame, GameStatus status) {
        if (FAILED.equals(status)) {
            Command command = readCommand();
            status = invokeIfRetry(bridgeGame, status, command);
        }
        return status;
    }

    private Command readCommand() {
        try {
            String code = inputView.readGameCommand();
            return Command.from(code);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readCommand();
        }
    }

    private GameStatus invokeIfRetry(BridgeGame bridgeGame, GameStatus status, Command command) {
        if (RETRY.equals(command)) {
            status = bridgeGame.retry();
        }
        return status;
    }
}
