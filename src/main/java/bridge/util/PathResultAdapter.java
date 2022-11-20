package bridge.util;

import static bridge.constant.BridgeGameConstant.DOWN_SIGN;
import static bridge.constant.BridgeGameConstant.UP_SIGN;
import static bridge.model.RoundStatus.FAIL;

import bridge.model.RoundStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PathResultAdapter {

    //check
    public static List<String> changePathResult(List<String> course, RoundStatus roundStatus) {
        return new ArrayList<>(List.of(fitToFormat(getUpWardPathResult(course, roundStatus)),
                fitToFormat(getDownWardPathResult(course, roundStatus))));
    }

    //check
    private static String fitToFormat(String pathResult) {
        return "[" + pathResult + "]";
    }

    //check
    private static String getUpWardPathResult(List<String> course, RoundStatus roundStatus) {
        return getPathResults(UP_SIGN, course, roundStatus);
    }

    private static String getDownWardPathResult(List<String> course, RoundStatus roundStatus) {
        return getPathResults(DOWN_SIGN, course, roundStatus);
    }

    private static String getPathResults(String selected, List<String> course, RoundStatus roundStatus) {
        if (roundStatus.equals(FAIL)) {
            return getPathResultsWhenFail(selected, course, roundStatus);
        }
        return course.stream().map(s -> getPathResult(s, selected)).collect(Collectors.joining(" | "));
    }

    private static String getPathResultsWhenFail(String selected, List<String> course, RoundStatus roundStatus) {
        String result = IntStream.range(0, course.size() - 1).mapToObj(i -> getPathResult(course.get(i), selected))
                .collect(Collectors.joining("|"));
        result += ("|" + getPathResultWhenFail(course.get(course.size() - 1), selected));
        return result;
    }

    private static String getPathResultWhenFail(String courseDirection, String selectedDirection) {
        if (courseDirection.equals(selectedDirection)) {
            return " X ";
        }
        return "   ";
    }

    private static String getPathResult(String courseDirection, String selectedDirection) {
        if (courseDirection.equals(selectedDirection)) {
            return " O ";
        }
        return "   ";
    }
}
