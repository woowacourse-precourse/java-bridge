package bridge.domain;

import java.util.Arrays;
import java.util.List;

public enum Dir {
    UP_MOVABLE("U", "O", true),
    UP_NOT_MOVABLE("U", "X", true),
    UP_NOT_SELECTED("U", " ", false),
    DOWN_MOVABLE("D", "O", true),
    DOWN_NOT_MOVABLE("D", "X", true),
    DOWN_NOT_SELECTED("D", " ", false);

    private final String direction;
    private final String isMovable;
    private final boolean isSelected;

    Dir(String direction, String isMovable, boolean isSelected) {
        this.direction = direction;
        this.isMovable = isMovable;
        this.isSelected = isSelected;
    }

    public static Dir getSelectedDir(Position position, Bridge bridge) {
        return Arrays.stream(Dir.values())
                .filter(dir -> dir.isSelected)
                .filter(dir -> findSelectedDir(dir, position, bridge))
                .findAny()
                .orElse(null);
    }

    public static Dir getNotSelectedDir(Position position) {
        return Arrays.stream(Dir.values())
                .filter(dir -> !dir.isSelected)
                .filter(dir -> findNotSelectedDir(dir, position))
                .findAny()
                .orElse(null);
    }

    private static boolean findSelectedDir(Dir dir, Position position, Bridge bridge) {
        if (bridge.compare(position)) {
            if (position.getDirection().isSameUp()) {
                return dir.direction.equals("U") && dir.isMovable.contains("O");
            }
            return dir.direction.equals("D") && dir.isMovable.contains("O");
        }
        if (position.getDirection().isSameUp()) {
            return dir.direction.equals("U") && dir.isMovable.contains("X");
        }
        return dir.direction.equals("D") && dir.isMovable.contains("X");
    }

    private static boolean findNotSelectedDir(Dir dir, Position position) {
        if (position.getDirection().isSameUp()) {
            return dir.direction.equals("U");
        }
        return dir.direction.equals("D");
    }

    public String getIsMovable() {
        return isMovable;
    }

    public static boolean isContainX(List<Dir> dirs) {
        if (dirs.stream().anyMatch(dir -> dir.isMovable.contains("X"))) {
            return true;
        }
        return false;
    }
}
