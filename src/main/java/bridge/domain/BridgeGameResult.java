package bridge.domain;

import java.util.Objects;

import static bridge.domain.enumeration.MovingType.DOWN;
import static bridge.domain.enumeration.MovingType.UP;

public class BridgeGameResult {

    private final boolean isMatched;
    private final String userMoving;

    public BridgeGameResult(boolean isMatched, String userMoving) {
        this.isMatched = isMatched;
        this.userMoving = userMoving;
    }

    public boolean getIsMatched() {
        return this.isMatched;
    }

    public String getUserMoving() {
        return this.userMoving;
    }
}
