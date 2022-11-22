package bridge.status;

public class Bridge {

    private static final int BRIDGE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_UPPER_INCLUSIVE = 20;

    private Bridge() {

    }

    public static boolean isInRange(String bridgeSize) {
        int size = bridgeSize.replaceFirst("^0*", "").length();
        if (size > Integer.toString(BRIDGE_UPPER_INCLUSIVE).length()) {
            return false;
        }

        int bridge = Integer.parseInt(bridgeSize);
        if (bridge < BRIDGE_LOWER_INCLUSIVE || bridge > BRIDGE_UPPER_INCLUSIVE) {
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
