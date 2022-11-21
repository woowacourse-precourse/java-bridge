package bridge.domain;


import bridge.util.Constant;
import bridge.util.Validator;

public enum SafeSpot {
    DOWN(0, Constant.DOWN),
    UP(1, Constant.UP);

    private final int locationNum;
    private final String location;

    SafeSpot(int locationNum, String location) {
        this.locationNum = locationNum;
        this.location = location;
    }

    public static String locationOf(int locationNum) {
        Validator.validateLocationNum(locationNum);
        for (SafeSpot spot : SafeSpot.values()) {
            if (locationNum == spot.locationNum) {
                return spot.location;
            }
        }
        throw new IllegalArgumentException(Constant.SPOTNAME_NOTING);
    }
}
