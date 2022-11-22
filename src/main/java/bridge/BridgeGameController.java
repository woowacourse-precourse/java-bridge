package bridge;

public class BridgeGameController {
    private InputView input;
    private OutputView output;
    private BridgeGame game;

    BridgeGameController() {
        input = new InputView();
        output = new OutputView();
    }

    public void gameStart() {
        output.printGameStart();
        game = new BridgeGame(input.readBridgeSize());
    }

    public void gameRun() {
        game.move(input.readMoving());
        output.printMap(game.getGameResult());
    }

    public boolean isGameContinue() {
        if (game.isFailed()) {
            return checkGameRetry();
        }
        if (game.isGameFinished()) {
            return false;
        }
        return true;
    }

    private boolean checkGameRetry() {
        if (GameCommand.RETRY == input.readGameCommand()) {
            game.retry();
            return true;
        }
        return false;
    }

    public void gameEnd() {
        output.printResult(game.getGameResult());
    }
}
