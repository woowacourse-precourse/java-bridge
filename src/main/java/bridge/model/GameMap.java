package bridge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameMap {
    private final Map<Direction, List<DrawType>> map = new EnumMap<>(Direction.class);

    public GameMap() {
        initialize();
    }

    public void draw(Direction direction, DrawType drawType) {
        Arrays.stream(Direction.values()).forEach(directionType -> {
            if (directionType == direction) {
                map.get(directionType).add(drawType);
                return;
            }
            map.get(directionType).add(DrawType.BLANK);
        });
    }

    public void initialize() {
        if (map.isEmpty()) {
            Arrays.stream(Direction.values()).forEach(direction -> map.put(direction, new ArrayList<>()));
            return;
        }
        Arrays.stream(Direction.values()).forEach(direction -> map.get(direction).clear());
    }

    private String showBoardByType(Direction direction) {
        return "[ " +
                map.get(direction).stream()
                        .map(DrawType::getDrawCharacter)
                        .collect(Collectors.joining(" | "))
                + " ]";
    }

    @Override
    public String toString() {
        return Arrays.stream(Direction.values()).map(this::showBoardByType).collect(Collectors.joining("\n"));
    }
}
