package bridge;

import bridge.exception.CannotCrossBridgeException;
import java.util.List;

public class Application {

    private static final InputView inputView = new InputView(new BridgeValidator());
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printGameStart();
        BridgeGame bridgeGame = initBridgeGame();

        startGame(bridgeGame);
    }

    private static void startGame(BridgeGame bridgeGame) {
        try {
            crossBridge(bridgeGame);
            endGame(new GameResult(bridgeGame.getBridgeStatus(), GameStatus.SUCCESS,
                bridgeGame.getAttemptCount()));
        } catch (CannotCrossBridgeException exception) {
            outputView.printMap(bridgeGame.getBridgeStatus());
            outputView.printGuideForGameCommand();
            String gameCommand = inputView.readGameCommand();
            retry(bridgeGame, gameCommand);
        }
    }

    private static void retry(BridgeGame bridgeGame, String gameCommand) {
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            startGame(bridgeGame);
        }

        if (gameCommand.equals("Q")) {
            endGame(new GameResult(bridgeGame.getBridgeStatus(), GameStatus.FAIL,
                bridgeGame.getAttemptCount()));
        }
    }

    private static void endGame(GameResult gameResult) {
        outputView.printResult(gameResult);
    }

    private static void crossBridge(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        for (int bridgeIndex = 0; bridgeIndex < bridge.size(); bridgeIndex++) {
            String direction = inputMoveDirection();
            bridgeGame.move(direction, bridgeIndex);
            outputView.printMap(bridgeGame.getBridgeStatus());
        }
    }

    private static String inputMoveDirection() {
        outputView.printGuideForMoveDirection();
        return inputView.readMoving();
    }

    private static BridgeGame initBridgeGame() {
        return new BridgeGame(makeBridge());
    }

    private static List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        outputView.printGuideForBridgeSize();
        int bridgeSize = inputView.readBridgeSize();

        return bridgeMaker.makeBridge(bridgeSize);
    }
}
