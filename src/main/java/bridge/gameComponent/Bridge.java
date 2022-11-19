package bridge.gameComponent;

import bridge.exception.ExceptionMessage;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isPossibleMove(int index, String upDown) {
        validateUpDown(upDown);
        validateIndex(index);
        return bridge.get(index).equals(upDown);
    }

    private void validateUpDown(String upDown) {
        if (!(upDown.equals("U") || upDown.equals("D"))) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_U_OR_D.getMessage());
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= bridge.size()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_BRIDGE_SIZE.getMessage());
        }
    }
}
