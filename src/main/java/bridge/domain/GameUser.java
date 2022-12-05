package bridge.domain;

import java.util.ArrayList;

public class GameUser {
    private final Bridge userBridge = new Bridge(new ArrayList<>());

    public void move(String moving) {
        userBridge.addBlock(moving);
    }

    public void reset() {
        userBridge.reset();
    }

    public boolean isGetOutFrom(Bridge otherBridge) {
        return !userBridge.isPartOfBridgeInOrder(otherBridge);
    }

    public boolean isOnTheFinalBlockOf(Bridge otherBridge) {
        return userBridge.length() == otherBridge.length();
    }

    @Override
    public String toString() {
        return userBridge.toString();
    }
}
