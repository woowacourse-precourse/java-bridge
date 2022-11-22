package bridge;

import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static Integer attempt = 1;
    static String result = Constant.SUCCESS;

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Integer bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        while (!bridgeGame.isEnd()) {
            play(bridgeGame);
        }
        outputView.printResult(result, attempt);
    }

    public static void play(BridgeGame bridgeGame) {
        String moving = inputView.readMoving();
        Boolean moved = bridgeGame.move(moving);
        outputView.printMap(bridgeGame, moved);
        if (moved || !askAgain(bridgeGame)) {
            return;
        }
        bridgeGame.retry();
    }

    public static Boolean askAgain(BridgeGame bridgeGame) {
        String again = inputView.readGameCommand();
        if (again.equalsIgnoreCase(Constant.QUIT)) {
            result = Constant.FAILURE;
            bridgeGame.quitGame();
            return false;
        }
        attempt += 1;
        return true;
    }
}
