package bridge;

import bridge.enums.Direction;

import java.util.List;

/**
 * Bridge 클래스는 directions를 상태 값으로 가지는 객체이다.
 * 객체는 객체스럽게 사용하라는 요구에 맞춰보자
 */
public class Bridge {
    private final List<Direction> directions;
    public Bridge(List<String> directions) {
        this.directions = Direction.convertBridge(directions);
    }
    public Direction get(int stage) {
        return directions.get(stage - 1);
    }
    public boolean isDirectionMatched(int stage, Direction direction) {
        return directions.get(stage - 1).equals(direction);
    }
    public boolean isLastStage(int stage) {
        return directions.size() == stage;
    }

}
