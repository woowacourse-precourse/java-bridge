package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.MovingMap;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class BridgeGameMachine {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        printStartGame();

        int bridgeSize = inputBridgeSize();
        BridgeGame bridgeGame = createNewGame(bridgeSize);

        while (bridgeGame.isGameEnd()) {
            playOneTurn(bridgeGame);
        }

        printResult(bridgeGame);
    }

    private void playOneTurn(BridgeGame bridgeGame) {
        String moving = inputMoving();
        bridgeGame.move(moving);
        printMovingMap(bridgeGame);

        if (!bridgeGame.canContinue() && bridgeGame.isGameEnd()) {
            checkRetry(bridgeGame);
        }
    }

    private void checkRetry(BridgeGame bridgeGame) {
        String gameCommand = inputGameCommand();
        if ("R".equals(gameCommand)) {
            bridgeGame.retry();
        }
        if ("Q".equals(gameCommand)) {
            bridgeGame.finishGame();
        }
    }

    private void printResult(BridgeGame bridgeGame) {
        MovingMap movingMap = bridgeGame.getMovingMap();
        boolean isClear = bridgeGame.isGameClear();
        int tryCount = bridgeGame.getTryCount();
        outputView.printResult(movingMap, isClear, tryCount);
    }

    private String inputGameCommand() {
        return repeatInputUntilSuccess(() -> {
            outputView.printEnterGameCommand();
            return inputView.readGameCommand();
        });
    }

    private void printMovingMap(BridgeGame bridgeGame) {
        MovingMap movingMap = bridgeGame.getMovingMap();
        outputView.printMap(movingMap);
        outputView.println();
    }

    private String inputMoving() {
        return repeatInputUntilSuccess(() -> {
            outputView.printEnterMoving();
            return inputView.readMoving();
        });
    }

    private int inputBridgeSize() {
        return repeatInputUntilSuccess(() -> {
            outputView.printEnterBridgeSize();
            int bridgeSize = inputView.readBridgeSize();
            outputView.println();
            return bridgeSize;
        });
    }

    private void printStartGame() {
        outputView.printStartGame();
        outputView.println();
    }

    private BridgeGame createNewGame(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Player player = new Player();

        return new BridgeGame(bridge, player);
    }

    private <T> T repeatInputUntilSuccess(
            Supplier<T> callback) {
        while (true) {
            try {
                return callback.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
