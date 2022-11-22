package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = initGame();
        boolean isContinue = true;
        while (isContinue) {
            isContinue = gameFlow(game);
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
        List<String> history = game.getCrossedBridge();
        OutputView.printMap(history, isAvailable);
        if (!isAvailable || game.mapSize() == history.size()) {
            if (isAvailable || InputView.readGameCommandUntilSuccess().equals("Q")) {
                OutputView.printResult(history, isAvailable, game.getTries());
                return false;
            }
            game.retry();
        }
        return true;
    }
}
