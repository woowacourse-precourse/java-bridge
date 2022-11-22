package bridge;

public class BridgeGameRunner {
    private final InputView input;
    private final OutputView output;
    private final BridgeMaker maker;
    private final BridgeGame game;

    public BridgeGameRunner() {
        input = new InputView();
        game = new BridgeGame();
        output = new OutputView(game);
        maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {
        output.printStartMessage();
        game.initBridge(maker.makeBridge(input.readBridgeSize()));
        while (true) {
            repeatMove();
            if (game.isSuccess() || !askRetry()) {
                break;
            }
            game.retry();
        }
        output.printResult();
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
            output.printMap();
        }
    }
}
