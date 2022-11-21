package bridge.model.domain;

import bridge.model.validation.Move;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List <List <String>> Map = new ArrayList <>();

    public Map() {
        Map.add(new ArrayList <>());
        Map.add(new ArrayList <>());
    }

    public void draw(List <String> roundTrace) {
        Map.get(0).add(roundTrace.get(Move.MOVE_DOWN.getMoveValue()));
        Map.get(1).add(roundTrace.get(Move.MOVE_UP.getMoveValue()));
    }

    public void reset() {
        Map.get(0).clear();
        Map.get(1).clear();
    }

    public List <List <String>> getMap() {
        return Map;
    }

}
