package bridge.gameComponent;

import bridge.exception.ExceptionMessage;
import bridge.util.UserInput;

import java.util.List;

public class BridgeImpl implements Bridge {
    private final List<String> bridge;

    public BridgeImpl(List<String> bridge) {
        validateBridge(bridge);
        this.bridge = bridge;
    }

    private static void validateBridge(List<String> bridge) {
        if (bridge == null || bridge.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
        for (String space : bridge) {
            validateUpDown(space);
        }
    }

    private static void validateUpDown(String upDown) {
        if (!(upDown.equals(UserInput.UP.getInputValue()) || upDown.equals(UserInput.DOWN.getInputValue()))) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_U_OR_D.getMessage());
        }
    }

    @Override
    public List<String> getBridge() {
        return bridge;
    }

    @Override
    public boolean isPossibleMove(int index, String upDown) {
        return bridge.get(index).equals(upDown);
    }
}
