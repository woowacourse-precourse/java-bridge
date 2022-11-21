package bridge.domain.resources.bridge;

import bridge.constant.BridgePhrase;
import java.util.List;
import java.util.Objects;

public class Bridge {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateUpOrDown(bridge);
        this.bridge = bridge;
    }

    private void validateUpOrDown(final List<String> bridge) {
        bridge.stream()
            .filter(str -> str.equals(UP) || str.equals(DOWN))
            .findFirst()
            .orElseThrow(()-> new IllegalArgumentException(BridgePhrase.ERROR_BRIDGE_GENERATION.getMessage()));
    }

    public boolean isStepOk(final String input, final int index){
        return Objects.equals(input, bridge.get(index));
    }
}
