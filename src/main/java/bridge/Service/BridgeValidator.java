package bridge.Service;

import bridge.Model.BridgeShape;
import bridge.Model.ErrorMessage;

import java.util.List;

public class BridgeValidator {

    public static final String UP = BridgeShape.UP.getShape();
    public static final String DOWN = BridgeShape.DOWN.getShape();

    public void validate(List<String> shape) {
        boolean result = shape.stream()
                .allMatch(s -> UP.equals(s) || DOWN.equals(s));

        if (result == false) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_CONTENT_ERROR.getMessage());
        }
    }
}
