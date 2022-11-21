package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.enums.Direction;
import bridge.domain.enums.GameCommand;
import bridge.domain.enums.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

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
        int size = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(size));
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
                final Direction direction = Direction.of(inputView.readMoving());
                return bridgeGame.move(direction);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private GameStatus retry() {
        while (true) {
            try {
                final GameCommand gameCommand = GameCommand.of(inputView.readGameCommand());
                return bridgeGame.retry(gameCommand);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
