package bridge.constant;

import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;

public final class BridgeRule {
    public static final int MINIMUM_SIZE = 3;
    public static final int MAXIMUM_SIZE = 20;
    public static final int INITIAL_TRY_COUNT = 1;
    public static final int RANDOM_LOWER_INCLUSIVE = 0;
    public static final int RANDOM_UPPER_INCLUSIVE = 1;
    public static final int MOVING_DISTANCE = 1;
    public static final int INITIAL_LOCATION = 0;

    public static String convertRandomNumberToMoving(int randomNumber) {
        if (randomNumber == RANDOM_UPPER_INCLUSIVE) {
            return UPPER_SIDE;
        }
        return LOWER_SIDE;
    }
}