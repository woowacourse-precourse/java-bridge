package bridge.domain.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static bridge.util.Constants.*;

public class BridgeGameResult {
    private final List<String> upperBridge;
    private final List<String> downBridge;

    public BridgeGameResult() {
        this.upperBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    public List<String> getUpperBridge() {
        return Collections.unmodifiableList(upperBridge);
    }

    public List<String> getDownBridge() {
        return Collections.unmodifiableList(downBridge);
    }

    public void update(String userMoving, boolean correct) {
        String correctString = changeCorrectToString(correct);

        if (isUpperBridgeMoving(userMoving)) {
            updateUpperBridge(correctString);
            return;
        }
        updateDownBridge(correctString);
    }

    private void updateDownBridge(String correctString) {
        upperBridge.add(NO_INPUT);
        downBridge.add(correctString);
    }

    private void updateUpperBridge(String correctString) {
        upperBridge.add(correctString);
        downBridge.add(NO_INPUT);
    }

    private boolean isUpperBridgeMoving(String userMovingOption) {
        return userMovingOption.equals(MovingType.MOVING_UP.getEngNotation());
    }

    private String changeCorrectToString(boolean correct) {
        if (correct) {
            return IS_CORRECT;
        }
        return IS_WRONG;
    }


}
