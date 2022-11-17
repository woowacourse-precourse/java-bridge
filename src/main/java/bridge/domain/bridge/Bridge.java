package bridge.domain.bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridgeShapeNumbers) {
        this.bridge = new ArrayList<>();
        for (String number : bridgeShapeNumbers) {
            String bridgeShape = checkBridgeShape(number);
            this.bridge.add(bridgeShape);
        }
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean isPassable(int userLocation, String userSelection) {
        String bridgeShape = bridge.get(userLocation);
        return bridgeShape.equals(userSelection);
    }

    private String checkBridgeShape(String number) {
        if (number.equals("0")) {
            return "D";
        }
        return "U";
    }
}
