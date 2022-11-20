package bridge;

public class BridgeGameRunner {
    private InputView input;
    private OutputView output;
    BridgeGame game;

    public BridgeGameRunner() {
        input = new InputView();
        output = new OutputView();
        game = new BridgeGame();
    }

    public void run() {
        output.printStartMessage();
        game.setBridge(new Bridge(game.getPlayer(), input.readBridgeSize()));
        while (true) {
            repeatMove();
            if (game.isSuccess() || !askRetry()) {
                break;
            }
            game.retry();
        }
        output.printResult(game);
    }

    private boolean askRetry() {
        if (input.readGameCommand().equals(BridgeGame.CMD_RETRY)) {
            return true;
        }
        return false;
    }

    private void repeatMove() {
        while (game.isPlayerAlive() && !game.isSuccess()) {
            game.move(input.readMoving());
            output.printMap(game.getBridge());
        }
    }
}
