package bridge.Service;

import bridge.Model.BridgeShape;
import bridge.Model.BridgeSize;
import bridge.Model.ErrorMessage;

import java.util.List;

public class BridgeValidator {

    private static int MIN_SIZE = BridgeSize.MIN_SIZE.getSize();
    private static int MAX_SIZE = BridgeSize.MAX_SIZE.getSize();
    public static final String UP = BridgeShape.UP.getShape();
    public static final String DOWN = BridgeShape.DOWN.getShape();

    public void validate(List<String> shape) {
        boolean result = shape.stream()
                .allMatch(s -> UP.equals(s) || DOWN.equals(s));

        if (result == false) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_CONTENT_ERROR.getMessage());
        }

        int size = shape.size();
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIZE_ERROR.getMessage());
        }
    }
}
