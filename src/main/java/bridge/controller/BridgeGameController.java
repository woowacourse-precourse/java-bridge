package bridge.controller;

import bridge.*;
import bridge.model.BridgeGame;
import bridge.model.TotalResult;
import bridge.model.utils.GameCommands;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private static final int DEFAULT_DISTANCE = 1;
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    private final BridgeGame bridgeGame;

    private BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public static void start() {
        BridgeGame bridgeGame = BridgeGameInitializer.initializeBridgeGame();
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeGame);
        TotalResult result = bridgeGameController.progressByDistance(DEFAULT_DISTANCE);
        outputView.printResult(result);
    }

    private TotalResult progressByDistance(int distance) {
        TotalResult result = selectBridgeSideAndMove(distance);

        if (!result.win()) {
            return restartOrQuit(result);
        }
        if (result.winGame()) {
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
        if (gameCommand.equals(GameCommands.retry())) {
            return restart();
        }
        return result;
    }

    private TotalResult restart() {
        BridgeGame nextBridgeGame = bridgeGame.retry();
        BridgeGameController nextBridgeGameController = new BridgeGameController(nextBridgeGame);
        return nextBridgeGameController.progressByDistance(DEFAULT_DISTANCE);
    }

    @Override
    public String toString() {
        return String.format("< BridgeGameController of %s >", bridgeGame.toString());
    }
}
