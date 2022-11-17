package bridge.Model;

import java.util.ArrayList;
import java.util.List;

public class MapShape {

    private static final String SPLIT_UNIT = " | ";
    private static final String BLANK = " ";
    private static final String UPPER_CASE = "U";
    private static final String LOWER_CASE = "D";

    private static final List<String> upperMap = new ArrayList<>();
    private static final List<String> lowerMap = new ArrayList<>();

    public static void addShape(String nextMove, String moveResult) {
        if(nextMove.matches(UPPER_CASE)) {
            upperMap.add(moveResult);
            lowerMap.add(BLANK);
        }
        if(nextMove.matches(LOWER_CASE)) {
            upperMap.add(BLANK);
            lowerMap.add(moveResult);
        }
    }

    public void clearMap(){
        upperMap.clear();
        lowerMap.clear();
    }

    public static String stringUpperMap() {
        return getJoin(upperMap);
    }

    public static String stringLowerMap() {
        return getJoin(lowerMap);
    }

    private static String getJoin(List<String> shapeMap) {
        return String.join(SPLIT_UNIT, shapeMap);
    }

}
