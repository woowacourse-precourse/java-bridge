package bridge.domain;

import java.util.Arrays;
import java.util.List;

public enum DirectionType {
    UP_MOVABLE("U", "O", true),
    UP_NOT_MOVABLE("U", "X", true),
    UP_NOT_SELECTED("U", " ", false),
    DOWN_MOVABLE("D", "O", true),
    DOWN_NOT_MOVABLE("D", "X", true),
    DOWN_NOT_SELECTED("D", " ", false);

    private final String direction;
    private final String isMovable;
    private final boolean isSelected;

    DirectionType(String direction, String isMovable, boolean isSelected) {
        this.direction = direction;
        this.isMovable = isMovable;
        this.isSelected = isSelected;
    }

    public static DirectionType getSelectedDir(Position position, Bridge bridge) {
        return Arrays.stream(DirectionType.values())
                .filter(directionType -> directionType.isSelected)
                .filter(directionType -> findSelectedDir(directionType, position, bridge))
                .findAny()
                .orElse(null);
    }

    public static DirectionType getNotSelectedDir(Position position) {
        return Arrays.stream(DirectionType.values())
                .filter(directionType -> !directionType.isSelected)
                .filter(directionType -> findNotSelectedDir(directionType, position))
                .findAny()
                .orElse(null);
    }

    private static boolean findSelectedDir(DirectionType directionType, Position position, Bridge bridge) {
        if (bridge.compare(position)) {
            if (position.getDirection().isSameUp()) {
                return directionType.direction.equals("U") && directionType.isMovable.contains("O");
            }
            return directionType.direction.equals("D") && directionType.isMovable.contains("O");
        }
        if (position.getDirection().isSameUp()) {
            return directionType.direction.equals("U") && directionType.isMovable.contains("X");
        }
        return directionType.direction.equals("D") && directionType.isMovable.contains("X");
    }

    private static boolean findNotSelectedDir(DirectionType directionType, Position position) {
        if (position.getDirection().isSameUp()) {
            return directionType.direction.equals("U");
        }
        return directionType.direction.equals("D");
    }

    public String getIsMovable() {
        return isMovable;
    }

    public static boolean isContainX(List<DirectionType> directionTypes) {
        if (directionTypes.stream().anyMatch(directionType -> directionType.isMovable.contains("X"))) {
            return true;
        }
        return false;
    }
}
