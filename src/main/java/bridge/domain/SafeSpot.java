package bridge.domain;


import static bridge.util.Constant.*;
import static bridge.util.Validator.*;

public enum SafeSpot {
    DOWN(0, DOWNLOCATION),
    UP(1, UPLOCATION);

    private final int locationNum;
    private final String location;

    SafeSpot(int locationNum, String location) {
        this.locationNum = locationNum;
        this.location = location;
    }

    public static String locationOf(int locationNum) {
        validateLocationNum(locationNum);
        for (SafeSpot spot : SafeSpot.values()) {
            if (locationNum == spot.locationNum) {
                return spot.location;
            }
        }
        throw new IllegalArgumentException(SPOTNAME_NOTING);
    }
}
