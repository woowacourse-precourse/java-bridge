package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<Floor> floors;

    Bridge(List<Floor> floors) {
        this.floors = floors;
    }

    public boolean isSafe(int index, String input) {
        Floor floor = floors.get(index);
        return floor.isSafe(input);
    }

    public int size() {
        return floors.size();
    }
}
