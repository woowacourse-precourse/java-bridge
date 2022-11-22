package bridge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MovingMap {

    private static final String CORRECT = " O ";
    private static final String FAIL = " X ";
    private static final String NOT_SELECTED = "   ";

    private Map<String, List<String>> movingMap;

    public void init() {
        movingMap = new LinkedHashMap<>();
        movingMap.put(UpAndDown.UP.getCommand(), new ArrayList<>());
        movingMap.put(UpAndDown.DOWN.getCommand(), new ArrayList<>());
    }

    public String judgeStatus(String targetUpAndDown, String moving, boolean moveStatus) {
        if (moveStatus && targetUpAndDown.equals(moving)) { //
            return CORRECT;
        }
        if (!moveStatus && targetUpAndDown.equals(moving)) {
            return FAIL;
        }
        return NOT_SELECTED;
    }
}
