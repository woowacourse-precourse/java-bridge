package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> DIRECTIONS = new ArrayList<>(List.of(Direction.D.toString(), Direction.U.toString()));
    private List<String> path;
    private Map map;

    public Player() {
        this.path = new ArrayList<>();
        this.map = new Map();
    }

    public void move(String direction, String answer) {
        validateDirection(direction);
        map.update(direction, answer);
        path.add(direction);
    }

    public List<String> generateMap() {
        return map.getCurrentMap();
    }

    public int getPathSize() {
        return path.size();
    }

    public boolean compareWith(List<String> bridge) {
        int index = path.size() - 1;
        return path.get(index).equals(bridge.get(index));
    }

    public boolean hasSucceeded(List<String> bridge) {
        return path.equals(bridge);
    }

    private void validateDirection(String direction) {
        if (!DIRECTIONS.contains(direction)) {
            throw new IllegalArgumentException("[ERROR] 이동 방향은 U 혹은 D만 입력할 수 있습니다.");
        }
    }
}
