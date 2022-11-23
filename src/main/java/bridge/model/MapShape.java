package bridge.model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.*;
import static bridge.util.Constant.*;

public class MapShape {

    private static final String SPLIT_UNIT = " | ";
    private static final String BLANK = " ";

    private static final List<String> upperMap = new ArrayList<>();
    private static final List<String> lowerMap = new ArrayList<>();

    // 결과 Map 에 O or X 를 add
    public void addShape(String nextMove, String moveResult) {
        if(nextMove.equals(MOVE_TO_UPPER)) {
            upperMap.add(moveResult);
            lowerMap.add(BLANK);
        }
        if(nextMove.equals(MOVE_TO_LOWER)) {
            upperMap.add(BLANK);
            lowerMap.add(moveResult);
        }
    }

    public void clearMap(){
        upperMap.clear();
        lowerMap.clear();
    }

    // 형식에 맞는 String 으로 변환
    public String convertUpperMapToString() {
        return getJoinWithSplitUnit(upperMap);
    }

    public String convertLowerMapToString() {
        return getJoinWithSplitUnit(lowerMap);
    }

    private String getJoinWithSplitUnit(List<String> shapeMap) {
        return join(SPLIT_UNIT, shapeMap);
    }

}
