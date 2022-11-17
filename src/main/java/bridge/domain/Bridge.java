package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<Direction> directions;

    public Bridge(List<String> directionData) {
        this.directions = makeDirectionsByStrings(directionData);
    }

    private List<Direction> makeDirectionsByStrings(List<String> directionData) {
        List<Direction> result = new ArrayList<>();
        for (String direction : directionData) {
            result.add(Direction.getDirectionByString(direction));
        }
        return result;
    }

}
