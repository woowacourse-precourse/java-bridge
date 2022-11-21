package bridge;

import bridge.exception.CannotCrossBridgeException;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        try {
            outputView.printGameStart();
            BridgeGame bridgeGame = initBridgeGame();
            startGame(bridgeGame);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }

    private void startGame(BridgeGame bridgeGame) {
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

    private BridgeGame initBridgeGame() {
        return new BridgeGame(makeBridge());
    }

    private List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        outputView.printGuideForBridgeSize();
        int bridgeSize = inputView.readBridgeSize();

        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void retry(BridgeGame bridgeGame, String gameCommand) {
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            startGame(bridgeGame);
        }

        if (gameCommand.equals("Q")) {
            endGame(new GameResult(bridgeGame.getBridgeStatus(), GameStatus.FAIL,
                bridgeGame.getAttemptCount()));
        }
    }

    private void endGame(GameResult gameResult) {
        outputView.printResult(gameResult);
    }

    private void crossBridge(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        for (int bridgeIndex = 0; bridgeIndex < bridge.size(); bridgeIndex++) {
            String direction = inputMoveDirection();
            bridgeGame.move(direction, bridgeIndex);
            outputView.printMap(bridgeGame.getBridgeStatus());
        }
    }

    private String inputMoveDirection() {
        outputView.printGuideForMoveDirection();
        return inputView.readMoving();
    }
}
