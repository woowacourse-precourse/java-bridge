package bridge;

import bridge.domain.BridgeLength;
import bridge.domain.BridgeStatus;
import bridge.domain.GameStatus;
import bridge.domain.MovingCommand;
import bridge.domain.RetryCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();
        outputView.printEmptyLine();
        create();
        while (true) {
            BridgeStatus bridgeStatus = move();
            GameStatus gameStatus = bridgeStatus.getGameStatus();
            if (gameStatus.equals(GameStatus.SUCCESS)) {
                outputView.printResult(bridgeStatus);
                return;
            }
            if (!retry(gameStatus)) {
                outputView.printResult(bridgeStatus);
                return;
            }
        }
    }

    private void create() {
        BridgeLength size = inputView.readBridgeSize();
        bridgeGame.createBridge(size);
        outputView.printEmptyLine();
    }

    private BridgeStatus move() {
        MovingCommand movingCommand = inputView.readMoving();
        BridgeStatus bridgeStatus = bridgeGame.move(movingCommand);
        outputView.printMap(bridgeStatus);
        outputView.printEmptyLine();
        return bridgeStatus;
    }

    private boolean retry(GameStatus gameStatus) {
        if (gameStatus.needCallRetry()) {
            RetryCommand retryCommand = inputView.readGameCommand();
            return bridgeGame.retry(retryCommand);
        }
        return true;
    }
}
