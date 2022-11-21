package bridge.commom.constant;

import java.util.List;

import static bridge.commom.constant.GameMessage.Exception.*;
import static bridge.commom.constant.GameCommand.*;

public class LocationTable {

    private static final List<String> locationList = List.of(DOWN_COMMAND, UPPER_COMMAND);

    public static String getKeyWithIndex(int index) {
        return locationList.get(index);
    }

    public static String getAlternativeKey(String key) {
        if (isDownCommand(key)) {
            return UPPER_COMMAND;
        }
        if (isUpperCommand(key)) {
            return DOWN_COMMAND;
        }

        throw new IllegalArgumentException(NO_ALTER_KEY);
    }
}
