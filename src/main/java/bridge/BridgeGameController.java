package bridge;

public class BridgeGameController {
    private InputView input;
    private OutputView output;
    private BridgeGame game;

    BridgeGameController() {
        input = new InputView();
        output = new OutputView();
    }

    /**
     * 게임을 시작한다.
     */
    public void gameStart() {
        output.printGameStart();
        BridgeSize bridgeSize = getBridgeSizeUntilValid();
        game = new BridgeGame(bridgeSize);
        System.out.println();
    }

    /**
     * BridgeSize를 입력받아 유효한 값이 입력될 때까지 반복한다.
     *
     * @return BridgeSize
     */
    private BridgeSize getBridgeSizeUntilValid() {
        while (true) {
            try {
                return input.readBridgeSize();
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * 게임을 진행한다.
     */
    public void gameRun() {
        Direction direction = getDirectionUntilValid();
        game.move(direction);
        output.printMap(game.getGameResult());
    }

    /**
     * Direction을 입력받아 유효한 값이 입력될 때까지 반복한다.
     *
     * @return Direction
     */
    private Direction getDirectionUntilValid() {
        while (true) {
            try {
                return input.readMoving();
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * 게임이 지속되는지 확인한다.
     * 
     * @return 게임이 지속되는 경우 true, 그렇지 않은 경우 false
     */
    public boolean isGameContinue() {
        if (game.isFailed()) {
            return checkGameRetry();
        }
        if (game.isGameFinished()) {
            return false;
        }
        return true;
    }

    /**
     * 유저가 게임을 다시 시작할지 확인한다.
     */
    private boolean checkGameRetry() {
        if (GameCommand.RETRY == getGammeCommandUntilValid()) {
            game.retry();
            return true;
        }
        return false;
    }

    /**
     * GameCommand를 입력받아 유효한 값이 입력될 때까지 반복한다.
     *
     * @return GameCommand
     */
    private GameCommand getGammeCommandUntilValid() {
        while (true) {
            try {
                return input.readGameCommand();
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * 게임을 종료한다.
     */
    public void gameEnd() {
        output.printResult(game.getGameResult());
    }
}
