package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> directions;

    public Bridge(List<String> directions) {
        this.directions = directions;
    }

    public Boolean canCross(Integer location, String direction) {
        return directions.get(location).equals(direction);
    }

    public Integer getSize() {
        return directions.size();
    }
}
