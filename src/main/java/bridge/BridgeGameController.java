package bridge;

import java.util.List;

public class BridgeGameController {

    private static final int DEFAULT_TRY_COUNT = 1;
    private static final int DEFAULT_DISTANCE = 1;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private final BridgeGame bridgeGame;

    private BridgeGameController(BridgeGame bridgeGame){
        this.bridgeGame = bridgeGame;
    }

    public static TotalResult start() {
        outputView.printGameStartMessage();
        BridgeGame bridgeGame = initializeBridgeGame();
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeGame);
        return bridgeGameController.progressBridgeGame(DEFAULT_DISTANCE);
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

    private TotalResult progressBridgeGame(int distance) {
        TotalResult result = move(distance);

        if (!result.win()) {
            return restartOrNot(result);
        }
        if (bridgeGame.getBridgeSize() == distance) {
            return result;
        }
        return progressBridgeGame(distance + 1);
    }

    private TotalResult move(int distance) {
        String movingSide = inputView.readMoving();
        TotalResult result = bridgeGame.move(movingSide, distance);
        outputView.printMap(result.getRouteMap());
        return result;
    }

    private TotalResult restartOrNot(TotalResult result) {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(GameCommands.RETRY)) {
            return restart();
        }
        return result;
    }

    private TotalResult restart() {
        BridgeGame nextBridgeGame = bridgeGame.retry();
        BridgeGameController nextBridgeGameController = new BridgeGameController(nextBridgeGame);
        return progressBridgeGame(1);
    }
}
