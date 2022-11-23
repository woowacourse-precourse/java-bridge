package bridge.domain.result;

import static bridge.constant.gameValue.DOWN;
import static bridge.constant.gameValue.UP;

import bridge.domain.game.Bridge;
import bridge.domain.game.Position;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ResultType {

    UP_MOVABLE("U", "O", true),
    UP_NOT_MOVABLE("U", "X", true),
    UP_NOT_SELECTED("U", " ", false),
    DOWN_MOVABLE("D", "O", true),
    DOWN_NOT_MOVABLE("D", "X", true),
    DOWN_NOT_SELECTED("D", " ", false);

    private static final String MOVABLE = "O";
    private static final String NOT_MOVABLE = "X";
    private static final String DELIMITER = " | ";
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private final String direction;
    private final String isMovable;
    private final boolean isSelected;

    ResultType(String direction, String isMovable, boolean isSelected) {
        this.direction = direction;
        this.isMovable = isMovable;
        this.isSelected = isSelected;
    }

    public static ResultType getSelectedDirection(Position position, Bridge bridge) {
        return Arrays.stream(ResultType.values())
                .filter(type -> type.isSelected)
                .filter(type -> findSelectedDirection(type, position, bridge))
                .findAny()
                .orElse(null);
    }

    public static ResultType getNotSelectedDirection(Position position) {
        return Arrays.stream(ResultType.values())
                .filter(type -> !type.isSelected)
                .filter(type -> findNotSelectedDirection(type, position))
                .findAny()
                .orElse(null);
    }

    private static boolean findSelectedDirection(ResultType type, Position position, Bridge bridge) {
        if (position.isDirectionUp()) {
            return findUpDirection(type, position, bridge);
        }
        return findDownDirection(type, position, bridge);
    }

    private static boolean findUpDirection(ResultType type, Position position, Bridge bridge) {
        if (bridge.canMove(position)) {
            return type.direction.equals(UP) && type.isMovable.contains(MOVABLE);
        }
        return type.direction.equals(UP) && type.isMovable.contains(NOT_MOVABLE);
    }

    private static boolean findDownDirection(ResultType type, Position position, Bridge bridge) {
        if (bridge.canMove(position)) {
            return type.direction.equals(DOWN) && type.isMovable.contains(MOVABLE);
        }
        return type.direction.equals(DOWN) && type.isMovable.contains(NOT_MOVABLE);
    }

    private static boolean findNotSelectedDirection(ResultType type, Position position) {
        if (position.isDirectionUp()) {
            return type.direction.equals(UP);
        }
        return type.direction.equals(DOWN);
    }

    public static boolean isContainNotMovable(List<ResultType> types) {
        return types.stream()
                .anyMatch(type -> type.isMovable.contains(NOT_MOVABLE));
    }

    public static String reformatTypes(List<ResultType> types) {
        return types.stream()
                .map(type -> type.isMovable)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }
}
