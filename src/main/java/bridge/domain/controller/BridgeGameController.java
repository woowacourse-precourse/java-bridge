package bridge.domain.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.enums.Direction;
import bridge.domain.enums.GameCommand;
import bridge.domain.enums.GameStatus;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;

    public BridgeGameController() {
    }

    public void run() {
        outputView.printGameStart();
        init();
        GameStatus status = GameStatus.KEEP_GOING;
        while (status == GameStatus.KEEP_GOING) {
            status = play();
        }
        outputView.printResult(bridgeGame, status);
    }

    public void init() {
        while (true) {
            try {
                bridgeGame = new BridgeGame(createBridge());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private Bridge createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = inputBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private int inputBridgeSize() {
        return inputView.readBridgeSize();
    }

    private GameStatus play() {
        GameStatus result = goForward();
        outputView.printMap(bridgeGame.getFootPrintsLog());
        if (result == GameStatus.LOSE) {
            result = retry();
        }
        return result;
    }

    private GameStatus goForward() {
        while (true) {
            try {
                Direction direction = inputView.readMoving();
                return bridgeGame.move(direction);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private GameStatus retry() {
        while (true) {
            try {
                GameCommand gameCommand = inputView.readGameCommand();
                return bridgeGame.retry(gameCommand);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
