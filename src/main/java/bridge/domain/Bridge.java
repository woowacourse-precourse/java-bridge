package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge of(List<String> generatedBridge) {
        return new Bridge(generatedBridge);
    }

    public Result play(Bridge otherBridge) {
        if (bridge.equals(otherBridge.bridge)) {
            return Result.WIN;
        }
        if (bridge.subList(0,otherBridge.bridge.size()).equals(otherBridge.bridge)) {
            return Result.KEEP;
        }
        return Result.LOSE;
    }
}
