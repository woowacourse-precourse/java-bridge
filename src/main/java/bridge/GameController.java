package bridge;

import bridge.model.BridgeGame;
import bridge.model.Direction;
import bridge.model.TryCount;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    TryCount tryCount;
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    public GameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.tryCount = new TryCount();
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void start() {
        outputView.printStart();
        makeBridge();
        while (!bridgeGame.isEndOfBridge()) {
            outputView.printMap(crossBridge());
            if (failToMove()) {
                break;
            }
        }
        outputView.printResult(bridgeGame.isEndOfBridge(), tryCount.toString());
    }

    private void makeBridge() {
        outputView.AskBridgeLength();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.makeBridge(bridgeSize, new BridgeRandomNumberGenerator());
    }

    private String crossBridge() {
        outputView.AskNextMove();
        Direction direction = inputView.readMoving();
        String map = bridgeGame.move(direction);
        return map;
    }

    private boolean failToMove() {
        if (bridgeGame.failToMove()) {
            outputView.AskRetry();
            if (isGameOver(inputView.readGameCommand())) {
                return true;
            }
        }
        return false;
    }

    private boolean isGameOver(String gameCommand) {
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            tryCount.add();
        }
        if (gameCommand.equals("Q")) {
            return true;
        }
        return false;
    }
}
