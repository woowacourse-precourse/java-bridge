package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge of(List<String> generatedBridge) {
        return new Bridge(generatedBridge);
    }

    public Result play(UserPosition userPosition) {
        if (matchLastPosition(userPosition)) {

        }
    }
}

