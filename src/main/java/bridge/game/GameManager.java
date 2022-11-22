package bridge.game;

import bridge.BridgeMaker;
import bridge.etc.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    private GameState gameState = GameState.CONTINUE;

    public void game() {
        outputView.printStartMessage();
        initBridge();

        while (!gameState.equals(GameState.EXIT)) {
            moveBridge();
            endGame();
        }
    }

    private void initBridge() {
        System.out.println();
        outputView.printInputBridgeLengthMessage();
        Integer size = inputView.readBridgeSize();

        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));

        bridgeGame = new BridgeGame(bridge);
    }

    private void moveBridge() {
        while (gameState.equals(GameState.CONTINUE)) {
            outputView.printInputMoveDirectionMessage();
            String command = inputView.readMoving();
            gameState = bridgeGame.move(command);
            outputView.printMap(bridgeGame.getBridge(), gameState);
        }
    }

    private void endGame() {
        if (gameState.equals(GameState.FAIL)) {
            retryBridge();
        }

        if (gameState.equals(GameState.CLEAR)) {
            clearGame();
        }
    }

    private void clearGame() {
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getTryCount(), GameState.CLEAR);
        this.gameState = GameState.EXIT;
    }

    private void retryBridge() {
        outputView.printInputRetryMessage();
        String command = inputView.readGameCommand();

        gameState = bridgeGame.retry(command);
        if (gameState.equals(GameState.EXIT)) {
            outputView.printResult(bridgeGame.getBridge(), bridgeGame.getTryCount(), GameState.FAIL);
        }
    }
}
