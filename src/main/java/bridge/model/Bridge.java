package bridge.model;

import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        if (Objects.isNull(bridge)) {
            throw new IllegalArgumentException();
        }
        validate(bridge);

        this.bridge = bridge;
    }

    private void validate(List<String> bridge) {
        if (!bridge.stream().allMatch(v -> v.equals("U") || v.equals("D"))) {
            throw new IllegalArgumentException();
        }
    }
}
