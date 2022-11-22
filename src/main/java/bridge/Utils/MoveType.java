package bridge.Utils;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MoveType {
    DOWN(0, "D"),
    UP(1, "U");
    private final int value;
    private final String strValue;

    private static final Map<Integer, String> moveTypeMap =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(MoveType::getIntValue, MoveType::getStrValue)));

    MoveType(int value, String type) {
        this.value = value;
        this.strValue = type;
    }

    public int getIntValue() {
        return value;
    }

    public String getStrValue() {
        return strValue;
    }

    public static String findMoveTypeValueByNum(int num) {
        return moveTypeMap.get(num);
    }

}
