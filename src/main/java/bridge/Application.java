package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.dto.GameResult;
import bridge.dto.MoveResult;
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
        outputView.printResult(bridge,gameResult);
    }

    private static GameResult play(Bridge bridge) {
        MoveResult moveResult = moveToBridge(bridge);
        if (!moveResult.isSuccess()) {
            return selectWhetherToRetry(bridge, moveResult);
        }

        if (!bridgeGame.isGameClear()) {
            return play(bridge);
        }
        return bridgeGame.closeGame(moveResult);
    }

    private static MoveResult moveToBridge(Bridge bridge) {
        MoveResult moveResult = bridgeGame.move(bridge, inputView.readMoving());
        outputView.printMap(bridge,moveResult);
        return moveResult;
    }

    private static GameResult selectWhetherToRetry(Bridge bridge, MoveResult moveResult) {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            return play(bridge);
        }
        return bridgeGame.closeGame(moveResult);
    }

}
