package bridge;

import static bridge.GameStatus.GAME_SUCCESS;
import static bridge.GameStatus.GAME_FAIL;
import static bridge.GameStatus.GAME_CONTINUE;
import static bridge.GameStatus.GAME_INVALID;

public class Controller {
    private BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        outputView.printStart();
        outputView.printBridgeSizeRequest();
        initializeBridgeGameSafeLoop();
        outputView.printNewline();
    }

    private void initializeBridgeGameSafeLoop() {
        boolean flag = true;
        while (flag) {
            flag = initializeBridgeGame();
        }
    }

    private boolean initializeBridgeGame() {
        try {
            bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator())
                    .makeBridge(inputView.readBridgeSize()));
            return (false);
        } catch (IllegalArgumentException ex) {
            outputView.printExceptionMessage(ex.getMessage());
            return (true);
        }
    }

    private void moveSafeLoop() {
        boolean flag = true;
        while (flag) {
            flag = move();
        }
    }

    private boolean move() {
        try {
            bridgeGame.move(inputView.readMoving());
            return (false);
        } catch (IllegalArgumentException ex) {
            outputView.printExceptionMessage(ex.getMessage());
            return (true);
        }
    }

    private boolean askRetrySafeLoop() {
        GameStatus status = GAME_INVALID;
        outputView.printRestartOrQuit();
        while (status.isInvalid()) {
            status = askRetry();
        }
        if (status.isContinue()) {
            bridgeGame.retry();
        }
        return (status.isContinue());
    }

    private GameStatus askRetry() {
        try {
            return (inputView.readGameCommand());
        } catch (IllegalArgumentException ex) {
            outputView.printExceptionMessage(ex.getMessage());
            return (GAME_INVALID);
        }
    }
}
