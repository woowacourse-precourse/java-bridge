package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<Floor> floors;

    public Bridge(List<String> floors) {
        this.floors = floors.stream()
                .map(Floor::new)
                .collect(Collectors.toList());
    }

    public boolean isSafe(int index, String input) {
        Floor floor = floors.get(index);
        return floor.isSafe(input);
    }

    public int size() {
        return floors.size();
    }

}
