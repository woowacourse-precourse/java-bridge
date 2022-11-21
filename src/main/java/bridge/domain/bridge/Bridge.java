package bridge.domain.bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridgeShape) {
        this.bridge = bridgeShape;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean isPassable(int playerLocation, String playerSelection) {
        String bridgeShape = bridge.get(playerLocation);
        return bridgeShape.equals(playerSelection);
    }
}
