package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.Model.RetryQuitTable;
import bridge.Model.User;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class Controller {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;

    Controller(List<String> bridge) {
        bridgeGame = new BridgeGame(bridge);
    }

    public static void init() {
        outputView.printGameStart();
        outputView.printEnterLengthOfBridge();
        int size = inputView.readBridgeSize();
        outputView.printNextLine();
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(generator);
        List<String> bridge = maker.makeBridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    public static boolean move(){
        outputView.printEnterMove();
        String direction = inputView.readMoving();
        boolean movable = bridgeGame.isMovable(direction);
        bridgeGame.move(direction, movable);
        return movable;
    }

    public static boolean Round() {
        while (!bridgeGame.getSuccess()) {
            boolean movable = move();
            outputView.printTotalMap(bridgeGame.getUser().getPathOfUpperBridge(), bridgeGame.getUser().getPathOfLowerBridge());
            if (!movable) {
                return false;
            }
        }
        return true;
    }

    public static void game() {
        while (!Round()) {
            outputView.printEnterRetryOrNot();
            String gameCommand = inputView.readGameCommand();
            boolean retry = RetryQuitTable.get(gameCommand);
            if (!retry) {
                break;
            }
            bridgeGame.retry();
        }
    }

    public static void runGame() {
        init();
        game();
        outputView.printResult(bridgeGame);
    }
}
