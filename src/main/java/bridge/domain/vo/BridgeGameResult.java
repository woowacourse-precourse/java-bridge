package bridge.domain.vo;

import java.util.Objects;

import static bridge.view.enumeration.ErrorMessage.MOVING_IS_NOT_U_AND_D;
import static bridge.domain.vo.enumeration.MovingType.DOWN;
import static bridge.domain.vo.enumeration.MovingType.UP;

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
            throw new IllegalArgumentException(MOVING_IS_NOT_U_AND_D.getErrorMessage());
        }
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
