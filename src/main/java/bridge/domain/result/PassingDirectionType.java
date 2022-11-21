package bridge.domain.result;

import bridge.domain.bridgeInfo.Bridge;
import bridge.domain.userInfo.Position;
import java.util.Arrays;
import java.util.List;

public enum PassingDirectionType {

    UP_MOVABLE("U", "O", true),
    UP_NOT_MOVABLE("U", "X", true),
    UP_NOT_SELECTED("U", " ", false),
    DOWN_MOVABLE("D", "O", true),
    DOWN_NOT_MOVABLE("D", "X", true),
    DOWN_NOT_SELECTED("D", " ", false);

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
        if (bridge.compare(position)) {
            if (position.getDirection().isSameUp()) {
                return type.direction.equals("U") && type.isMovable.contains("O");
            }
            return type.direction.equals("D") && type.isMovable.contains("O");
        }
        if (position.getDirection().isSameUp()) {
            return type.direction.equals("U") && type.isMovable.contains("X");
        }
        return type.direction.equals("D") && type.isMovable.contains("X");
    }

    private static boolean findNotSelectedDir(PassingDirectionType type, Position position) {
        if (position.getDirection().isSameUp()) {
            return type.direction.equals("U");
        }
        return type.direction.equals("D");
    }

    public String getIsMovable() {
        return isMovable;
    }

    public static boolean isContainNotMovable(List<PassingDirectionType> types) {
        return types.stream()
                .anyMatch(type -> type.isMovable.contains("X"));
    }
}
