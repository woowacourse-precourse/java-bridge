package bridge.domain;

import static bridge.constant.BridgeRule.INITIAL_TRY_COUNT;
import static bridge.constant.GameCommand.QUIT;
import static bridge.constant.GameCommand.RETRY;
import static bridge.constant.GameStatus.END;
import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.GameStatus.ON_WAY;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;

import bridge.constant.ErrorMessage;
import bridge.constant.GameStatus;
import java.util.List;

public class BridgeGame {
    private GameStatus gameStatus;
    private int tryCount;
    private final BridgeReferee bridgeReferee;
    private final BridgeDrawer bridgeDrawer;

    public BridgeGame(List<String> bridge) {
        this.gameStatus = ON_WAY;
        this.tryCount = INITIAL_TRY_COUNT;
        this.bridgeReferee = new BridgeReferee(bridge);
        this.bridgeDrawer = new BridgeDrawer();
    }

    public void move(String moving) {
        validateMoving(moving);
        GameStatus gameStatusAfterMoving = bridgeReferee.judge(moving);
        this.gameStatus = gameStatusAfterMoving;
        bridgeDrawer.record(moving, gameStatusAfterMoving);
    }

    public void retry(String gameCommand) {
        validateGameCommand(gameCommand);
        if (gameCommand.equals(RETRY)) {
            resetGame();
            return;
        }
        gameStatus = END;
    }

    public boolean isOnWay() {
        return gameStatus.equals(ON_WAY);
    }

    public boolean isFail() {
        return gameStatus.equals(FAIL);
    }

    public boolean isEnd() {
        return gameStatus.equals(END);
    }

    public boolean isSuccess() {
        return bridgeReferee.isCrossCompletely();
    }

    public String getSketch() {
        return bridgeDrawer.getSketch();
    }

    public int getTryCount() {
        return tryCount;
    }

    private void resetGame() {
        gameStatus = ON_WAY;
        tryCount += 1;
        bridgeReferee.resetLocation();
        bridgeDrawer.reset();
    }

    private void validateMoving(String moving) {
        if (moving.equals(UPPER_SIDE) || moving.equals(LOWER_SIDE)) {
            return;
        }
        throw new IllegalArgumentException(
                String.format(ErrorMessage.WRONG_MOVING_FORMAT.getValue(), UPPER_SIDE, LOWER_SIDE));
    }

    private void validateGameCommand(String gameCommand) {
        if (gameCommand.equals(RETRY) || gameCommand.equals(QUIT)) {
            return;
        }
        throw new IllegalArgumentException(
                String.format(ErrorMessage.WRONG_GAME_COMMAND_FORMAT.getValue(), RETRY, QUIT));
    }
}
