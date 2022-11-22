package bridge;

public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        BridgeGame game = new BridgeGame(input.readBridgeSize());
        while (true) {
            game.move(input.readMoving());
            output.printMap(game.getGameResult());
            if (game.isGameFailed()) {
                if (GameCommand.RETRY == GameCommand.getGameCommand(input.readGameCommand())) {
                    game.retry();
                    continue;
                }
                break;
            }
            if (game.isGameFinished()) {
                break;
            }
        }
        output.printResult(game.getGameResult());
    }
}
