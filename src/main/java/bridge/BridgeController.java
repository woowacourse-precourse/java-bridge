package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startBridgeGame() {
        outputView.printStart();
        outputView.printAskingBridgeSize();
        int bridgeSize = inputView.readBridgeSize();

        bridgeGame.createBridge(bridgeSize);
    }

    public void moveBridge() {
        boolean isFinish = true;
        while(isFinish) {
            outputView.printAskingMovingSide();
            String bridgeSide = inputView.readMoving();
            BridgeMap bridgeMap = bridgeGame.move(bridgeSide);
            outputView.printMap(bridgeMap);
            isFinish = bridgeGame.isFinish(bridgeSide);
        }
    }

    public boolean restartBridgeGame() {
        outputView.printGameCommand();
        String gameCommand = inputView.readGameCommand();
        BridgeGameCommandType gameCommandType = BridgeGameCommandType.getFindByGameCommand(gameCommand);

        bridgeGame.retry(gameCommandType);

        return gameCommandType.getIsRestart();
    }

    public void executeBridgeGame() {
        startBridgeGame();
        boolean isRestart = true;
        while(isRestart) {
            moveBridge();
            isRestart = restartBridgeGame();
        }
    }
}
