package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Result;
import bridge.domain.User;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameManager {
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    private final InputView input;
    private final OutputView output;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameManager() {
        input = new InputView();
        output = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void progress() {
        output.printStartGameMessage();
        initGameUntilNoError();
        System.out.println();
        progressBridgeGame();
        output.printResult(bridgeGame.getResult());
    }

    private void initGameUntilNoError() {
        while (true) {
            if (initGame()) {
                break;
            }
        }
    }

    private boolean initGame() {
        output.printInputBridgeSizeMessage();

        try {
            makeBridge(input.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private void makeBridge(int bridgeSize) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize), bridgeSize);
        startBridgeGame(bridge);
    }

    private void startBridgeGame(Bridge bridge) {
        bridgeGame = new BridgeGame(bridge, new User(), new Result());
    }

    private void progressBridgeGame() {
        while (!bridgeGame.isLastMoving()) {
            output.printInputMoveToMessage();
            String moveTo = input.readMoving();
            boolean move = bridgeGame.move(moveTo);
            output.printMap(bridgeGame.getResult());
            if (move) {
                continue;
            }
            if (!inputRetryOrQuitUntilNoError()) {
                break;
            }
        }
    }

    private boolean inputRetryOrQuitUntilNoError() {
        while (true) {
            if (checkInputError()) {
                break;
            }
        }

        return bridgeGame.getIsRunning();
    }

    private boolean checkInputError() {
        output.printInputRetryMessage();

        try {
            changeGameState(input.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private void changeGameState(String retryCommand) {
        if (retryCommand.equals(RETRY_COMMAND)) {
            bridgeGame.retry();
        }
        if (retryCommand.equals(QUIT_COMMAND)) {
            bridgeGame.isOver();
        }
    }
}
