package bridge;

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
}
