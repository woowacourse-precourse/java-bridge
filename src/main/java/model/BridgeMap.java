package model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    final List<GameResult> map;

    public BridgeMap() {
        map = new ArrayList<>();
    }

    public void updateMap(Boolean result) {
        map.add(GameResult.getByBoolean(result));
    }
}
