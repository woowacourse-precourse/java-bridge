package bridge;

import bridge.domain.Bridge;
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
            playGame(bridge);
        } while (!bridgeGame.isGameClear(bridge));
        outputView.printResult(bridgeGame.getResult());
    }

    private static void playGame(Bridge bridge) {
        MoveResult moveResult = moveToBridge(bridge);
        if (!moveResult.isCorrect()) {
            if (bridgeGame.retry(inputView.readGameCommand())) {
                outputView.clear();
                playGame(bridge);
            }
        }
    }

    private static MoveResult moveToBridge(Bridge bridge) {
        MoveResult moveResult = bridgeGame.move(bridge, inputView.readMoving());
        outputView.printMap(moveResult);
        return moveResult;
    }
}
