package bridge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MovingMap {

    private Map<String, List<String>> movingMap;

    public void init() {
        movingMap = new LinkedHashMap<>();
        movingMap.put(UpAndDown.UP.getCommand(), new ArrayList<>());
        movingMap.put(UpAndDown.DOWN.getCommand(), new ArrayList<>());
    }
}
