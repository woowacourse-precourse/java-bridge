package bridge;

import java.util.ArrayList;

public class GameUser {
    private final Bridge userBridge = new Bridge(new ArrayList<>());

    public void move(String moving) {
        userBridge.addBlock(moving);
    }

    public void reset() {
        userBridge.reset();
    }

    public boolean hasSameBridge(Bridge otherBridge) {
        return userBridge.isSame(otherBridge);
    }

    public boolean hasBridgeLength(int otherLength) {
        return userBridge.length() == otherLength;
    }
}
