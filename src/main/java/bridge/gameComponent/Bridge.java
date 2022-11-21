package bridge.gameComponent;

import bridge.exception.ExceptionMessage;
import bridge.util.UserInput;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public static Bridge of(List<String> bridge) {
        validateBridge(bridge);
        return new Bridge(bridge);
    }

    private static void validateBridge(List<String> bridge) {
        if(bridge == null || bridge.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
        for(String space : bridge) {
            validateUpDown(space);
        }
    }

    public boolean isPossibleMove(int index, String upDown) {
        return bridge.get(index).equals(upDown);
    }

    private static void validateUpDown(String upDown) {
        if (!(upDown.equals(UserInput.UP.getInputValue()) || upDown.equals(UserInput.DOWN.getInputValue()))) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_U_OR_D.getMessage());
        }
    }
}
