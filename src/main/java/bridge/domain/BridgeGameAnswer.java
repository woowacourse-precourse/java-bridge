package bridge.domain;

import bridge.common.ErrorMessage;
import java.util.List;
import java.util.Map;


public class BridgeGameAnswer {
    private static final int BRIDGE_LOWER_BOUND = 3;
    private static final int BRIDGE_UPPER_BOUND = 20;

    private final Map<Round, Direction> answer;

    private BridgeGameAnswer(List<String> bridge) {
        validate(bridge);
        this.answer = null;
    }

    private void validate(List<String> bridge) {
        int size = bridge.size();
        if (size < BRIDGE_LOWER_BOUND || size > BRIDGE_UPPER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidBridgeSize());
        }
    }
}
