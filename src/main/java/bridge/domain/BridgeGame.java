package bridge.domain;

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
    private BridgeMover bridgeMover;
    private BridgeDrawer bridgeDrawer;

    public BridgeGame(List<String> bridge) {
        this.gameStatus = ON_WAY;
        this.tryCount = 1;
        this.bridgeMover = new BridgeMover(bridge);
        this.bridgeDrawer = new BridgeDrawer();
    }

    public String move(String moving) {
        validateMoving(moving);
        GameStatus gameStatusAfterMoving = this.bridgeMover.go(moving);
        this.gameStatus = gameStatusAfterMoving;
        this.bridgeDrawer.record(moving, gameStatusAfterMoving);
        return this.bridgeDrawer.getSketch();
    }

    public void retry(String gameCommand) {
        validateGameCommand(gameCommand);
        if (gameCommand.equals(RETRY)) {
            this.gameStatus = ON_WAY;
            this.tryCount += 1;
            this.bridgeDrawer.turnBackOnce();
        }
        if (gameCommand.equals(QUIT)) {
            this.gameStatus = END;
        }
    }

    public boolean isOnWay() {
        return this.gameStatus.equals(ON_WAY);
    }

    public boolean isFail() {
        return this.gameStatus.equals(FAIL);
    }

    public boolean isEnd() {
        return this.gameStatus.equals(END);
    }

    public boolean isSuccess() {
        return this.bridgeMover.isCrossCompletely();
    }

    public String getSketch() {
        return this.bridgeDrawer.getSketch();
    }

    public int getTryCount() {
        return this.tryCount;
    }

    private void validateMoving(String moving) {
        if (moving.equals(UPPER_SIDE) || moving.equals(LOWER_SIDE)) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                ErrorMessage.WRONG_MOVING_FORMAT.getValue(), UPPER_SIDE, LOWER_SIDE
        ));
    }

    private void validateGameCommand(String gameCommand) {
        if (gameCommand.equals(RETRY) || gameCommand.equals(QUIT)) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                ErrorMessage.WRONG_GAME_COMMAND_FORMAT.getValue(), RETRY, QUIT
        ));
    }
}
