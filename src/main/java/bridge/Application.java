package bridge;

import java.util.List;

public class Application {

    private static String QUIT_SIGN = "Q";

    public static void main(String[] args) {
        BridgeGame game = initGame();
        while (true) {
            if (!gameFlow(game)) {
                break;
            }
        }
    }

    private static BridgeGame initGame() {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        OutputView.printStartGame();
        int size = InputView.readBridgeSizeUntilSuccess();
        return new BridgeGame(bridgeMaker.makeBridge(size));
    }

    private static boolean gameFlow(BridgeGame game) {
        String direction = InputView.readMovingUntilSuccess();
        boolean isAvailable = game.move(direction);
        OutputView.printMap(game.getCrossedBridge(), isAvailable);
        if (isEnd(isAvailable, game.getCrossedBridge(), game)) {
            OutputView.printResult(game.getCrossedBridge(), isAvailable, game.getTries());
            return false;
        }
        return true;
    }

    private static boolean isEnd(boolean isAvailable, List<String> history, BridgeGame game) {
        if (isAvailable && game.mapSize() != history.size()) {
            return false;
        }
        if (isAvailable || InputView.readGameCommandUntilSuccess().equals(QUIT_SIGN)) {
            return true;
        }
        game.retry();
        return false;
    }
}
