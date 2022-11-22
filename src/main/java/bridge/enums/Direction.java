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

    public static String getGuide() {
        StringBuilder guide = new StringBuilder();
        int totalDirectionCount = Direction.values().length;

        guide.append("(");
        makeGuide(guide, totalDirectionCount);
        guide.append(")");
        return guide.toString();
    }
    private static void makeGuide(StringBuilder guide, int totalDirectionCount) {
        int count = 0;
        for (Direction directions : Direction.values()) {
            count++;
            guide.append(directions.description).append(": ").append(directions.shortcut);
            if (count != totalDirectionCount) {
                guide.append(", ");
            }
        }
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

    public static boolean contains(String input) {
        return Arrays.stream(Direction.values())
                .map(element -> element.shortcut)
                .anyMatch(direction -> direction.equals(input));
    }

    public static String findDirection(int number) {
        return Arrays.stream(Direction.values())
                .filter(element -> element.directionNumber == number)
                .findFirst().get().shortcut;
    }

    public boolean isUp() {
        return this.equals(UP);
    }
    public boolean isDown() {
        return this.equals(DOWN);

    }
}
