package bridge.util;

import static bridge.model.RoundStatus.FAIL;
import static bridge.util.BridgeGameConstant.ACCESSIBLE_SIGN;
import static bridge.util.BridgeGameConstant.DOWN_SIGN;
import static bridge.util.BridgeGameConstant.INACCESSIBLE_SIGN;
import static bridge.util.BridgeGameConstant.START_INDEX;
import static bridge.util.BridgeGameConstant.UP_SIGN;

import bridge.model.RoundStatus;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapAdapter {

    private static final String SPLITTER = " | ";
    private static final String OPEN_BRACKET = "[ ";
    private static final String CLOSE_BRACKET = " ]";
    private static final String BLANK = " ";

    public static String changeMapToString(List<String> course, RoundStatus roundStatus) {
        return fitToFormat(getUpWardMap(course, roundStatus) + "\n" + fitToFormat(getDownWardMap(course, roundStatus)));
    }

    private static String fitToFormat(String map) {
        return OPEN_BRACKET + map + CLOSE_BRACKET;
    }

    private static String getUpWardMap(List<String> course, RoundStatus roundStatus) {
        return getMaps(UP_SIGN, course, roundStatus);
    }

    private static String getDownWardMap(List<String> course, RoundStatus roundStatus) {
        return getMaps(DOWN_SIGN, course, roundStatus);
    }

    private static String getMaps(String selected, List<String> course, RoundStatus roundStatus) {
        if (roundStatus.equals(FAIL)) {
            return getMapsWhenFail(selected, course, roundStatus);
        }
        return course.stream().map(s -> getMap(s, selected)).collect(Collectors.joining(" | "));
    }

    private static String getMapsWhenFail(String selected, List<String> course, RoundStatus roundStatus) {
        String result = IntStream.range(START_INDEX, course.size() - 1).mapToObj(i -> getMap(course.get(i), selected))
                .collect(Collectors.joining(SPLITTER));
        if (result.length() == 0) {
            return getMapWhenFail(course.get(course.size() - 1), selected);
        }
        result += (SPLITTER + getMapWhenFail(course.get(course.size() - 1), selected));
        return result;
    }

    private static String getMapWhenFail(String courseDirection, String selectedDirection) {
        if (courseDirection.equals(selectedDirection)) {
            return INACCESSIBLE_SIGN;
        }
        return BLANK;
    }

    private static String getMap(String courseDirection, String selectedDirection) {
        if (courseDirection.equals(selectedDirection)) {
            return ACCESSIBLE_SIGN;
        }
        return BLANK;
    }
}
