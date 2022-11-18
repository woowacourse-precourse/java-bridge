package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> bridge;
    private final List<String> directions = new ArrayList<>();
    private int playCount;

    public Player(List<String> bridge) {
        this.bridge = bridge;
        this.playCount = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getDirections() {
        return directions;
    }

    public int getPlayCount() {
        return playCount;
    }

    //== 비즈니스 로직 ==//
    public void addDirection(String direction) {
        directions.add(direction);
    }

    public boolean isGameEnd() {
        return directions.size() == bridge.size();
    }

    public void resetDirections() {
        directions.clear();
        playCount++;
    }

    public boolean isMovePossible() {
        int index = directions.size() - 1;
        return directions.get(index).equals(bridge.get(index));
    }
}
