package bridge.Domain;

import java.util.Collections;
import java.util.List;

public class UserBridges {
    private final UserBridge upperBridge;
    private final UserBridge lowerBridge;

    public UserBridges() {
        this.upperBridge = new UserBridge();
        this.lowerBridge = new UserBridge();
    }

    public List<String> getUpperSpaces() {
        return Collections.unmodifiableList(upperBridge.getSpaces());
    }

    public List<String> getLowerSpaces() {
        return Collections.unmodifiableList(lowerBridge.getSpaces());
    }

    public void saveMove(String upperMove, String lowerMove) {
        upperBridge.saveSpace(upperMove);
        lowerBridge.saveSpace(lowerMove);
    }

    public void resetSpaces() {
        upperBridge.resetSpace();
        lowerBridge.resetSpace();
    }
}
