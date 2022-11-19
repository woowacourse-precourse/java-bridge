package bridge.command;

public class Bridge {

    private static final int BRIDGE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_UPPER_INCLUSIVE = 20;

    private Bridge() {
        
    }

    public static boolean isInRange(int bridgeSize) {
        if (bridgeSize < BRIDGE_LOWER_INCLUSIVE || bridgeSize > BRIDGE_UPPER_INCLUSIVE) {
            return false;
        }

        return true;
    }

}
