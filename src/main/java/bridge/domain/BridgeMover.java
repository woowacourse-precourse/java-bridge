package bridge.domain;

import static bridge.constant.GameStatus.END;
import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.GameStatus.ON_WAY;

import bridge.constant.GameStatus;
import java.util.List;

public class BridgeMover {
    private List<String> bridge;
    private int location;

    public BridgeMover(List<String> bridge) {
        this.bridge = bridge;
        this.location = 0;
    }

    public GameStatus go(String moving) {
        boolean isCorrectMoving = this.bridge.get(this.location).equals(moving);
        if (!isCorrectMoving) {
            return FAIL;
        }
        this.location += 1;
        if (this.bridge.size() == location) {
            return END;
        }
        return ON_WAY;
    }
}
