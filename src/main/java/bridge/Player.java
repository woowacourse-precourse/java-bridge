package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Result.*;

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

    public List<Result> createMapInformation(String target) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < directions.size(); i++) {
            String direction = directions.get(i);
            if (direction.equals(target) && direction.equals(bridge.get(i))) {
                results.add(POSSIBLE);
            } else if (direction.equals(target) && !direction.equals(bridge.get(i))) {
                results.add(IMPOSSIBLE);
            } else {
                results.add(BLANK);
            }
            if (i < directions.size() - 1) {
                results.add(DIV);
            }
        }
        return results;
    }
}
