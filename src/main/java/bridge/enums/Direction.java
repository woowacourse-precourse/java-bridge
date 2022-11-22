package bridge.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Direction {
    UP("U", "위", 1),
    DOWN("D", "아래", 0);

    private final String shortcut;
    private final String description;
    private final int directionNumber;

    Direction(String shortcut, String description, int directionNumber) {
        this.shortcut = shortcut;
        this.description = description;
        this.directionNumber = directionNumber;
    }

    public static Direction find(String direction) {
        return Arrays.stream(Direction.values())
                .filter(element -> element.shortcut.equals(direction))
                .findFirst().get();
    }

    public static List<Direction> convertBridge(List<String> directions) {
        return directions.stream()
                .map(Direction::find)
                .collect(Collectors.toList());
    }

}
