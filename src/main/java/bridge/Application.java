package bridge;

import model.Bridge;
import model.Moving;
import view.InputView;
import view.OutputView;

public class Application {
    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();

    public static void main(String[] args) {
        outputView.printStart();
        BridgeGame bridgeGame = new BridgeGame();
        Bridge bridge = bridgeGame.setBridge(inputView.readBridgeSize());
        play(bridge, bridgeGame);
        outputView.printResult(bridgeGame, bridge);
    }

    public static void play(Bridge bridge, BridgeGame bridgeGame) {
        while (!bridgeGame.isFinish(bridge)) {
            if (bridgeGame.isMoving(bridge, move(bridge, bridgeGame))) {
                continue;
            }
            if (!isRestart(bridgeGame)) {
                break;
            }
        }
    }

    private static Moving move(Bridge bridge, BridgeGame bridgeGame) {
        Moving moving =  inputView.readMoving();
        bridgeGame.move(bridge, moving);
        outputView.printMap(bridgeGame.getMovedBridge());
        return moving;
    }

    private static boolean isRestart(BridgeGame bridgeGame) {
        if (!inputView.readGameCommand().isRestart())
            return false;
        bridgeGame.retry();
        return true;
    }
}
