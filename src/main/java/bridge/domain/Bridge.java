package bridge.domain;


import java.util.List;

public class Bridge {
    private final List<String> directions;

    public Bridge(List<String> directions) {
        this.directions = directions;
    }

    public String canMoveDirection(int idx) {
        return directions.get(idx);
    }
}
