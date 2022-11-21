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
        inputView.printStartMessage();
        Bridge bridge = bridgeGame.getBridge(inputView.readBridgeSize());
        GameResult gameResult = playBridgeGame(bridge);
        outputView.printResult(bridge,gameResult);
    }

    private static GameResult playBridgeGame(Bridge bridge) {
        MoveResult moveResult = moveToSelectedBlock(bridge);
        if (!moveResult.isSuccess()) {
            return selectWhetherToRetry(bridge, moveResult);
        }

        if (!bridgeGame.isGameClear()) {
            return playBridgeGame(bridge);
        }
        return bridgeGame.closeGame(moveResult);
    }

    private static MoveResult moveToSelectedBlock(Bridge bridge) {
        MoveResult moveResult = bridgeGame.move(bridge, inputView.readMoving());
        outputView.printMap(bridge,moveResult);
        return moveResult;
    }

    private static GameResult selectWhetherToRetry(Bridge bridge, MoveResult moveResult) {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            return playBridgeGame(bridge);
        }
        return bridgeGame.closeGame(moveResult);
    }
}
