package bridge;

import bridge.domain.Bridge;
import bridge.domain.Player;

public class ApplicationContainer {
    private static Player playerInstance;
    private static Bridge bridgeInstance;

    private ApplicationContainer() {
    }

    //Beans
    public static Player player() {
        if(playerInstance == null) {
            playerInstance = new Player();
        }
        return playerInstance;
    }

    public static Bridge bridge() {
        if(bridgeInstance == null) {
            bridgeInstance = new Bridge();
        }
        return bridgeInstance;
    }
}
