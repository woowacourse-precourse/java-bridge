package bridge;

import bridge.Input.InputView;
import bridge.Output.OutputView;

import java.util.List;

public class BridgeGameController {
    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private List<String> bridge;

    private BridgeGame bridgeGame;

    public BridgeGameController() {
        init();
    }

    public void startBridgeGame() {
        progress();
        outputView.printResult(bridgeGame);
    }

    private void init() {
        setting();
        outputView.printGameStart();
        createBridge();
        bridgeGame = new BridgeGame(bridge);
    }

    private void setting() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    }

    private void createBridge() {
        outputView.printBridgeSizeInput();
        try {
            int bridgeSize = inputView.readBridgeSize();
            bridge = bridgeMaker.makeBridge(bridgeSize);
            System.out.print("\n");
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_SIZE_ERROR_MESSAGE);
            createBridge();
        }
    }

    private void progress() {
        while (continueGame()) {
            moveBridge();
            outputView.printMap(bridgeGame);
        }
        routeGame();
    }

    private void moveBridge() {
        outputView.printMoveCommandInput();
        try {
            String moveCommand = inputView.readMoving();
            bridgeGame.move(moveCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.MOVE_COMMAND_ERROR_MESSAGE);
            moveBridge();
        }
    }

    private boolean retryGame() {
        outputView.printGameCommandInput();
        try {
            String gameCommand = inputView.readGameCommand();
            return isRetryCommand(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.RETRY_COMMAND_ERROR_MESSAGE);
            return retryGame();
        }
    }

    private boolean isRetryCommand(String gameCommand) {
        if (bridgeGame.retry(gameCommand)) {
            return true;
        }
        return false;
    }

    private boolean continueGame() {
        if (bridgeGame.isGameEnd() || !bridgeGame.succeedMove()) {
            return false;
        }
        return true;
    }

    private void routeGame() {
        if (!bridgeGame.isGameEnd()) {
            if (retryGame()) {
                progress();
            }
        }
    }
}
