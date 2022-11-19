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

    public boolean isPassable(int userLocation, String userSelection) {
        String bridgeShape = bridge.get(userLocation);
        return bridgeShape.equals(userSelection);
    }
}
