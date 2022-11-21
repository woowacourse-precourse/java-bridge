package bridge.domain.resources.bridge;

import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateUpOrDown(bridge);
        this.bridge = bridge;
    }

    private void validateUpOrDown(List<String> bridge) {
        bridge.stream()
            .filter(str -> str.matches("U"))
            .filter(str -> str.matches("D"))
            .findFirst()
            .orElseThrow(()-> new IllegalArgumentException("[ERROR]"));
    }

    public boolean isStepOk(String input, int index){
        return Objects.equals(input, bridge.get(index));
    }
}
