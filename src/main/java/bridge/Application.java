package bridge;

import bridge.game.BridgeGame;
import bridge.game.Status;
import bridge.game.GameCommand;
import bridge.input.InputView;
import bridge.map.Map;
import bridge.output.OutputView;

import java.util.List;

public class Application {

    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    Application() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    private void start() {
        OutputView.printStartMessage();

        int bridgeSize = InputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        bridgeGame = new BridgeGame(bridge);
        startBridgeGame();
    }

    private void startBridgeGame() {
        boolean quit = false;

        while (!quit) {
            int gameStatus = guess();
            quit = isQuit(gameStatus);
        }
    }

    private int guess() {
        int gameStatus = Status.CONTINUE.getNumber();

        while (gameStatus == Status.CONTINUE.getNumber()) {
            String moving = InputView.readMoving();
            gameStatus = bridgeGame.move(moving);
            OutputView.printMap(bridgeGame.getMap());
        }

        return gameStatus;
    }

    private boolean isQuit(int gameStatus) {
        if (gameStatus == Status.FAIL.getNumber()) {
            String gameCommand = InputView.readGameCommand();
            return !isRetry(gameCommand);
        }

        finish(true);
        return true;
    }

    private boolean isRetry(String gameCommand) {
        if (gameCommand.equals(GameCommand.RETRY.getLetter())) {
            bridgeGame.retry();
            return true;
        }

        finish(false);
        return false;
    }

    private void finish(boolean success) {
        Map lastMap = bridgeGame.getMap();
        int totalTry = bridgeGame.getTotalTry();

        OutputView.printResult(lastMap, success, totalTry);
    }
}
