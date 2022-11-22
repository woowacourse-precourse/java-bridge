package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MapComponentType {

    UP("U", 1),
    DOWN("D", 0);

    private final String mapComponent;
    private final int number;

    MapComponentType(String mapComponent, int number) {
        this.mapComponent = mapComponent;
        this.number = number;
    }

    public String getMapComponent() {
        return mapComponent;
    }

    public int getNumber() {
        return number;
    }

    public static String getMapComponentByNumber(int number) {
        return numberMap.get(number).getMapComponent();
    }

    private static final Map<Integer, MapComponentType> numberMap =
            Arrays.stream(MapComponentType.values())
            .collect(Collectors.toUnmodifiableMap(MapComponentType::getNumber, Function.identity()));


    public static boolean isBadMapComponent(String query) {
        return mapComponents.get(query) == null;
    }

    private static final Map<String, MapComponentType> mapComponents =
            Arrays.stream(MapComponentType.values())
                    .collect(Collectors.toUnmodifiableMap(MapComponentType::getMapComponent, Function.identity()));
}
