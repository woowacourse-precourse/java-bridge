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
        BridgeSize bridgeSize = getBridgeSizeUntilValid();
        game = new BridgeGame(bridgeSize);
        System.out.println();
    }

    private BridgeSize getBridgeSizeUntilValid() {
        while (true) {
            try {
                return input.readBridgeSize();
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    public void gameRun() {
        Direction direction = getDirectionUntilValid();
        game.move(direction);
        output.printMap(game.getGameResult());
    }

    private Direction getDirectionUntilValid() {
        while (true) {
            try {
                return input.readMoving();
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
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
        if (GameCommand.RETRY == getGammeCommandUntilValid()) {
            game.retry();
            return true;
        }
        return false;
    }

    private GameCommand getGammeCommandUntilValid() {
        while (true) {
            try {
                return input.readGameCommand();
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    public void gameEnd() {
        output.printResult(game.getGameResult());
    }
}
