package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import bridge.domain.MoveResult;
import bridge.view.InputView;
import bridge.view.InputViewProxy;
import bridge.view.OutputView;

public class Application {

    private static final InputView inputView = new InputViewProxy();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        Bridge bridge = bridgeGame.getBridge(inputView.readBridgeSize());
        GameResult gameResult = play(bridge);
        outputView.printResult(gameResult);
    }

    private static GameResult play(Bridge bridge) {
        MoveResult moveResult = moveToBridge(bridge);
        if (!moveResult.isSuccess()) {
            return selectWhetherToRetry(bridge);
        }

        if (!bridgeGame.isGameClear()) {
            play(bridge);
        }
        return bridgeGame.closeGame();
    }

    private static MoveResult moveToBridge(Bridge bridge) {
        MoveResult moveResult = bridgeGame.move(bridge, inputView.readMoving());
        outputView.printMap(moveResult);
        return moveResult;
    }

    private static GameResult selectWhetherToRetry(Bridge bridge) {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            outputView.resetMap();
            play(bridge);
        }
        return bridgeGame.closeGame();
    }
}
