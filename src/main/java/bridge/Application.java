package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printStartGameMessage();
        BridgeGame game = prepareGame();
        do {
            play(game);
        } while (!game.isCleared() && askRestartGame(game));
        OutputView.printResult(game);
    }

    private static BridgeGame prepareGame() {
        int bridgeLength = InputView.readBridgeLength();
        OutputView.printEmptyLine();
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeLength);
        return BridgeGame.create(bridge);
    }

    private static void play(BridgeGame game) {
        do {
            BridgeGameMovingInput moving = InputView.readMoving();
            game.move(moving);
            OutputView.printMap(game);
            OutputView.printEmptyLine();
        } while (game.isPlaying());
    }

    private static boolean askRestartGame(BridgeGame game) {
        BridgeGameCommandInput command = InputView.readGameCommand();
        if (command.equals(BridgeGameCommandInput.RETRY)) {
            game.retry();
            return true;
        }
        return false;
    }
}
