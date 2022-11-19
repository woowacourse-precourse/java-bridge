package bridge;

import bridge.domain.BridgeStatus;
import bridge.domain.GameStatus;

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
        outputView.printEmptyLine();
        int size = inputView.readBridgeSize();
        bridgeGame.createBridge(size);
        outputView.printEmptyLine();
    }

    private BridgeStatus move() {
        String moving = inputView.readMoving();
        BridgeStatus bridgeStatus = bridgeGame.move(moving);
        outputView.printMap(bridgeStatus);
        outputView.printEmptyLine();
        return bridgeStatus;
    }

    private boolean retry(GameStatus gameStatus) {
        if (gameStatus.needCallRetry()) {
            String gameCommand = inputView.readGameCommand();
            return bridgeGame.retry(gameCommand);
        }
        return true;
    }
}
