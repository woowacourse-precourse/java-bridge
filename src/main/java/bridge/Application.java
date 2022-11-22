package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgePassed;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        GameStatus gameStatus = new GameStatus();

        OutputView.printStart();
        OutputView.printBridgeSize();
        Bridge bridge = bridgeGame.makeBridge(InputView.readBridgeSize());

        while (!gameStatus.getEnd()) {
            crossBridge(bridgeGame, bridge, gameStatus);
        }

        OutputView.printFinalMap(bridgeGame.getBridgePassed());
        OutputView.printResult(gameStatus);
    }

    public static void crossBridge(BridgeGame bridgeGame, Bridge bridge, GameStatus gameStatus) {
        gameStatus.addGameCount();
        for (int i = 0; i < bridge.getBridgeSize(); i++) {
            BridgePassed bridgePassed = move(bridgeGame, bridge, i);
            OutputView.printMap(bridgePassed);
            if (!bridgePassed.canMove()) {
                retry(bridgeGame, gameStatus);
                return;
            }
        }
        gameStatus.setEnd(true);
        gameStatus.setGameClear(true);
    }

    private static void retry(BridgeGame bridgeGame, GameStatus gameStatus) {
        OutputView.printRetry();
        String inputRetry = InputView.readGameCommand();
        gameStatus.setEnd(bridgeGame.retry(inputRetry));
    }

    private static BridgePassed move(BridgeGame bridgeGame, Bridge bridge, int index) {
        OutputView.printMoving();
        String moving = InputView.readMoving();
        return bridgeGame.move(bridge, index, moving);
    }
}
