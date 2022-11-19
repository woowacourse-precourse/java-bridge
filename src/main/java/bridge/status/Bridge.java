package bridge.status;

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

    public static boolean isAvailable(String bridgeDirection, String userDirection) {
        if (!bridgeDirection.equals(userDirection)) {
            return false;
        }

        return true;
    }

}
