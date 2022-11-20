package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> DIRECTIONS = new ArrayList<>(List.of(Direction.D.toString(), Direction.U.toString()));
    private List<String> path;

    public Player() {
        this.path = new ArrayList<>();
    }

    public void move(String direction) {
        validateDirection(direction);
        path.add(direction);
    }

    public boolean compareWith(List<String> bridge) {
        int index = path.size() - 1;
        return path.get(index).equals(bridge.get(index));
    }

    private void validateDirection(String direction) {
        if (!DIRECTIONS.contains(direction)) {
            throw new IllegalArgumentException("[ERROR] 이동 방향은 U 혹은 D만 입력할 수 있습니다.");
        }
    }
}
