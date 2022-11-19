package bridge.util;

import java.util.Objects;

import static bridge.util.Constants.OutputViewConstants.DOWN;
import static bridge.util.Constants.OutputViewConstants.UP;

public class TypeConverter {

    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static char stringToChar(String s) {
        return s.charAt(0);
    }

    public static int blockToNumber(String movingBlock) {
        if (Objects.equals(movingBlock, UP)) {
            return 0;
        }

        if (Objects.equals(movingBlock, DOWN)) {
            return 1;
        }

        return -1;
    }
}
