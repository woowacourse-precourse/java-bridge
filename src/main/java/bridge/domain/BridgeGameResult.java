package bridge.domain;

import bridge.domain.vo.GameCommand;

import java.util.Objects;

import static bridge.domain.enumeration.MovingType.DOWN;
import static bridge.domain.enumeration.MovingType.UP;

public class BridgeGameResult {

    private final boolean isMatched;
    private final String userMoving;

    public static BridgeGameResult createBridgeGameResult(boolean isMatched, String userMoving) {
        return new BridgeGameResult(isMatched, userMoving);
    }

    private BridgeGameResult(boolean isMatched, String userMoving) {
        this.isMatched = isMatched;
        this.userMoving = userMoving;
    }

    public static boolean checkUp(String userMoving) {
        return Objects.equals(userMoving, UP.getMovingType());
    }

    public static boolean checkDown(String userMoving) {
        return Objects.equals(userMoving, DOWN.getMovingType());
    }

    public boolean getIsMatched() {
        return this.isMatched;
    }

    public String getUserMoving() {
        return this.userMoving;
    }
}
