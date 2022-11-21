package bridge.domain.result;

import bridge.domain.bridgeInfo.Bridge;
import bridge.domain.userInfo.Position;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public enum PassingDirectionType {

    UP_MOVABLE("U", "O", true),
    UP_NOT_MOVABLE("U", "X", true),
    UP_NOT_SELECTED("U", " ", false),
    DOWN_MOVABLE("D", "O", true),
    DOWN_NOT_MOVABLE("D", "X", true),
    DOWN_NOT_SELECTED("D", " ", false);

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String MOVABLE = "O";
    private static final String NOT_MOVABLE = "X";
    private final String direction;
    private final String isMovable;
    private final boolean isSelected;

    PassingDirectionType(String direction, String isMovable, boolean isSelected) {
        this.direction = direction;
        this.isMovable = isMovable;
        this.isSelected = isSelected;
    }

    public static PassingDirectionType getSelectedDir(Position position, Bridge bridge) {
        return Arrays.stream(PassingDirectionType.values())
                .filter(type -> type.isSelected)
                .filter(type -> findSelectedDir(type, position, bridge))
                .findAny()
                .orElse(null);
    }

    public static PassingDirectionType getNotSelectedDir(Position position) {
        return Arrays.stream(PassingDirectionType.values())
                .filter(type -> !type.isSelected)
                .filter(type -> findNotSelectedDir(type, position))
                .findAny()
                .orElse(null);
    }

    private static boolean findSelectedDir(PassingDirectionType type, Position position, Bridge bridge) {
        if (position.getDirection().isSameUp()) {
            return moveToUp(type, position, bridge);
        }
        return moveToDown(type, position, bridge);
    }

    private static boolean moveToUp(PassingDirectionType type, Position position, Bridge bridge) {
        if (bridge.compare(position)) {
            return type.direction.equals(UP) && type.isMovable.contains(MOVABLE);
        }
        return type.direction.equals(UP) && type.isMovable.contains(NOT_MOVABLE);
    }

    private static boolean moveToDown(PassingDirectionType type, Position position, Bridge bridge) {
        if (bridge.compare(position)) {
            return type.direction.equals(DOWN) && type.isMovable.contains(MOVABLE);
        }
        return type.direction.equals(DOWN) && type.isMovable.contains(NOT_MOVABLE);
    }

    private static boolean findNotSelectedDir(PassingDirectionType type, Position position) {
        if (position.getDirection().isSameUp()) {
            return type.direction.equals(UP);
        }
        return type.direction.equals(DOWN);
    }

    public static boolean isContainNotMovable(List<PassingDirectionType> types) {
        return types.stream()
                .anyMatch(type -> type.isMovable.contains(NOT_MOVABLE));
    }

    public static String reformat(List<PassingDirectionType> types) {
        return types.stream()
                .map(type -> type.isMovable)
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }
}
