package bridge;

import bridge.model.BridgeGame;
import bridge.model.Direction;
import bridge.model.TryCount;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final TryCount tryCount;
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameController(InputView inputView, OutputView outputView) {
        tryCount = new TryCount();
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(BridgeNumberGenerator bridgeNumberGenerator) {
        outputView.printStart();
        initBridgeGame(bridgeNumberGenerator);
        while (!bridgeGame.isEndOfBridge()) {
            outputView.printMap(crossBridge());
            if (failToMoveAndQuit()) {
                break;
            }
        }
        outputView.printResult(bridgeGame.isEndOfBridge(), tryCount.toString());
    }

    private void initBridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        outputView.AskBridgeLength();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize, bridgeNumberGenerator);
    }

    private String crossBridge() {
        outputView.AskNextMove();
        Direction direction = inputView.readMoving();
        String map = bridgeGame.move(direction);
        return map;
    }

    private boolean failToMoveAndQuit() {
        if (bridgeGame.failToMove()) {
            outputView.AskRetry();
            return isGameOver(inputView.readGameCommand());
        }
        return false;
    }

    private boolean isGameOver(String gameCommand) {
        if (gameCommand.equals("R")) {
            doRetry();
            tryCount.add();
        }
        return gameCommand.equals("Q");
    }

    private void doRetry() {
        try {
            bridgeGame.retry();
        } catch (IllegalStateException exception) {
            outputView.printError();
        }
    }
}
