package bridge.controller;

import bridge.*;
import bridge.model.BridgeGame;
import bridge.model.TotalResult;
import bridge.model.utils.GameCommands;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private static final int DEFAULT_TRY_COUNT = 1;
    private static final int DEFAULT_DISTANCE = 1;
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    private final BridgeGame bridgeGame;

    private BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public static TotalResult start() {
        outputView.printGameStartMessage();
        BridgeGame bridgeGame = initializeBridgeGame();
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeGame);
        return bridgeGameController.progressByDistance(DEFAULT_DISTANCE);
    }

    public static void printResult(TotalResult result) {
        outputView.printResult(result);
    }

    private static BridgeGame initializeBridgeGame() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new BridgeGame(bridge, DEFAULT_TRY_COUNT);
    }

    private TotalResult progressByDistance(int distance) {
        TotalResult result = selectBridgeSideAndMove(distance);

        if (!result.win()) {
            return restartOrQuit(result);
        }
        if (bridgeGame.getBridgeSize() == distance) {
            return result;
        }
        return progressByDistance(distance + 1);
    }

    private TotalResult selectBridgeSideAndMove(int distance) {
        String movingSide = inputView.readMoving();
        TotalResult result = bridgeGame.move(movingSide, distance);
        outputView.printMap(result.getPlayerMap());
        return result;
    }

    private TotalResult restartOrQuit(TotalResult result) {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(GameCommands.RETRY)) {
            return restart();
        }
        return result;
    }

    private TotalResult restart() {
        BridgeGame nextBridgeGame = bridgeGame.retry();
        BridgeGameController nextBridgeGameController = new BridgeGameController(nextBridgeGame);
        return progressByDistance(DEFAULT_DISTANCE);
    }
}
