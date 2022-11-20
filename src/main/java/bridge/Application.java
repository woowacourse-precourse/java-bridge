package bridge;

import bridge.game.BridgeGame;
import bridge.game.Status;
import bridge.game.GameCommand;
import bridge.input.InputView;
import bridge.map.Map;
import bridge.output.OutputView;

import java.util.List;

public class Application {

    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    Application() {
        inputView = new InputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    private void start() {
        OutputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
        process();
    }

    private void process() {
        boolean quit = false;
        while (!quit) {
            int gameStatus = guess();
            if (gameStatus == Status.FAIL.getNumber()) {
                quit = fail();
                continue;
            }
            quit = true;
            finish(true);
        }
    }

    private int guess() {
        int gameStatus = Status.CONTINUE.getNumber();
        while (gameStatus == Status.CONTINUE.getNumber()) {
            String moving = inputView.readMoving();
            gameStatus = bridgeGame.move(moving);
            OutputView.printMap(bridgeGame.getMap());
        }
        return gameStatus;
    }

    private void finish(boolean success) {
        Map lastMap = bridgeGame.getMap();
        int totalTry = bridgeGame.getTotalTry();
        OutputView.printResult(lastMap, success, totalTry);
    }

    private boolean fail() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(GameCommand.RETRY.getLetter())) {
            bridgeGame.retry();
            return false;
        }
        finish(false);
        return true;
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
