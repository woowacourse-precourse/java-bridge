package bridge;

import java.util.List;

public class BridgeUtils {

    public String canPass(final int bridgeNumber) {
        if (bridgeNumber == 0) {
            return "D";
        }
        if (bridgeNumber == 1) {
            return "U";
        }
        return null;
    }

    public List<String> addMoving(List<String> movings, String moving) {
        movings.add(moving);
        return movings;
    }
}
