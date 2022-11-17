package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class MapShape {

    private static final String SPLIT_UNIT = " | ";
    private static final String BLANK = " ";
    private static final String MOVE_TO_UPPER = "U";
    private static final String MOVE_TO_LOWER = "D";

    private static final List<String> upperMap = new ArrayList<>();
    private static final List<String> lowerMap = new ArrayList<>();

    public void addShape(String nextMove, String moveResult) {
        if(nextMove.matches(MOVE_TO_UPPER)) {
            upperMap.add(moveResult);
            lowerMap.add(BLANK);
        }
        if(nextMove.matches(MOVE_TO_LOWER)) {
            upperMap.add(BLANK);
            lowerMap.add(moveResult);
        }
    }

    public void clearMap(){
        upperMap.clear();
        lowerMap.clear();
    }

    public String upperMapToString() {
        return getJoin(upperMap);
    }

    public String lowerMapToString() {
        return getJoin(lowerMap);
    }

    private String getJoin(List<String> shapeMap) {
        return String.join(SPLIT_UNIT, shapeMap);
    }

}
