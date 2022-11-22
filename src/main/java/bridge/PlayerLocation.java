package bridge;

import static bridge.BridgeGameCount.COUNT_PLUS_CRITERIA;

public class PlayerLocation {

    private final int location;

    public PlayerLocation(int location) {
        this.location = location;
    }

    public PlayerLocation addLocation() {
        return new PlayerLocation(this.location + COUNT_PLUS_CRITERIA);
    }

    public int getLocation() {
        return this.location;
    }

}
