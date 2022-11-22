package Controller;

import Model.Map;
import java.util.List;

public class BridgeGame {

    public boolean move(Map map, int index, String moving) {
        List<String> crossable = map.getCrossable();

        map.extendMap(index);
        boolean isWin = map.runMap(moving, crossable.get(index));
        map.endMap();

        return isWin;
    }

    public int retry(Map map, int attempts) {
        map.startMap();

        return ++attempts;
    }

}



