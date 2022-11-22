package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeSize;
import bridge.model.Direction;
import bridge.model.GameCommand;
import bridge.model.GameMap;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        initBridgeGame();
        playBridgeGame();
        gameOver();
    }

    private static void initBridgeGame() {
        outputView.printGameStart();
        bridgeGame = new BridgeGame(createBridge(), new Player(), new GameMap());
    }

    private static void playBridgeGame() {
        while (!bridgeGame.quit()) {
            play(bridgeGame);
        }
    }

    private static void gameOver() {
        GameResult gameResult = bridgeGame.gameResult();
        outputView.printResult(bridgeGame.getGameMap(), gameResult.getResult(), gameResult.getRetryCount());
    }

    private static void play(BridgeGame bridgeGame) {
        bridgeGame.move(inputDirection());
        outputView.printMap(bridgeGame.getGameMap());
        retryGameWhenGameFailed(bridgeGame);
    }

    private static void retryGameWhenGameFailed(BridgeGame bridgeGame) {
        if (bridgeGame.end()) {
            bridgeGame.retry(inputGameCommand());
        }
    }

    private static BridgeSize inputBridgeSize() {
        try {
            return new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputBridgeSize();
        }
    }

    private static Bridge createBridge() {
        BridgeSize bridgeSize = inputBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
    }

    private static Direction inputDirection() {
        try {
            return Direction.fromInput(inputView.readDirection());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputDirection();
        }
    }

    private static GameCommand inputGameCommand() {
        try {
            return GameCommand.fromInput(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputGameCommand();
        }
    }
}
