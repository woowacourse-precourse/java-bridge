package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
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
        do {
            MoveResult moveResult = moveToBridge(bridge);
            if (!moveResult.isSuccess()) {
                selectRestartGame();
            }
        } while (!bridgeGame.isGameClear(bridge));
        outputView.printResult(bridgeGame.getResult());
    }

    private static MoveResult moveToBridge(Bridge bridge) {
        MoveResult moveResult = bridgeGame.move(bridge, inputView.readMoving());
        outputView.printMap(moveResult);
        return moveResult;
    }

    private static void selectRestartGame() {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            outputView.resetMap();
        }
    }
}
