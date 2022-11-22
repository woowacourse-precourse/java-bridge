package bridge.model.domain;

import bridge.model.validation.Move;

import java.util.List;

public class Map {
    private final StringBuilder map1;
    private final StringBuilder map2;

    public Map() {
        map1 = new StringBuilder();
        map2 = new StringBuilder();
    }

    public void draw(List <String> roundTrace) {
        map1.append(roundTrace.get(Move.MOVE_UP.getMoveValue()));
        map2.append(roundTrace.get(Move.MOVE_DOWN.getMoveValue()));
    }

    public String getMap1() {
        return map1.substring(0, map1.length() - 1);
    }

    public String getMap2() {
        return map2.substring(0, map2.length() - 1);
    }

    public void reset() {
        map1.setLength(0);
        map2.setLength(0);
    }
}
