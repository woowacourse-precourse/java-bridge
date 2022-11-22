package bridge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameMap {
    private final Map<Moving, List<DrawType>> map = new EnumMap<>(Moving.class);

    public GameMap() {
        initialize();
    }

    public void draw(Moving moving, DrawType drawType) {
        Arrays.stream(Moving.values()).forEach(directionType -> {
            if (directionType == moving) {
                map.get(directionType).add(drawType);
                return;
            }
            map.get(directionType).add(DrawType.BLANK);
        });
    }

    public void initialize() {
        if (map.isEmpty()) {
            Arrays.stream(Moving.values()).forEach(direction -> map.put(direction, new ArrayList<>()));
            return;
        }
        Arrays.stream(Moving.values()).forEach(direction -> map.get(direction).clear());
    }

    private String showBoardByType(Moving moving) {
        return "[ " +
                map.get(moving).stream()
                        .map(DrawType::getDrawCharacter)
                        .collect(Collectors.joining(" | "))
                + " ]";
    }

    @Override
    public String toString() {
        return Arrays.stream(Moving.values()).map(this::showBoardByType).collect(Collectors.joining("\n"));
    }
}
