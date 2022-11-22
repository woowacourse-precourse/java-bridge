package bridge.domain.vo;

import java.util.Objects;

import static bridge.enumeration.Command.DOWN;
import static bridge.enumeration.Command.UP;
import static bridge.enumeration.ErrorMessage.INVALID_MOVE;

public class BridgeGameResult {

    private final boolean isMatched;
    private final String userMoving;

    public static BridgeGameResult confirmGameResult(boolean isMatched, String userMoving) {
        return new BridgeGameResult(isMatched, userMoving);
    }

    private BridgeGameResult(boolean isMatched, String userMoving) {
        validateBrideGameResult(isMatched, userMoving);
        this.isMatched = isMatched;
        this.userMoving = userMoving;
    }

    private void validateBrideGameResult(boolean isMatched, String userMoving) {
        if (!checkDown(userMoving) && !checkUp(userMoving)) {
            throw new IllegalArgumentException(INVALID_MOVE.getMessage());
        }
    }

    public static boolean checkUp(String userMoving) {
        return Objects.equals(userMoving, UP.getCommand());
    }

    public static boolean checkDown(String userMoving) {
        return Objects.equals(userMoving, DOWN.getCommand());
    }

    public boolean getIsMatched() {
        return this.isMatched;
    }

    public String getUserMoving() {
        return this.userMoving;
    }
}
