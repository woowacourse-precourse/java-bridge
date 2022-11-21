package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MapComponentType {

    UP("U"),
    DOWN("D");

    private final String mapComponent;

    MapComponentType(String mapComponent) {
        this.mapComponent = mapComponent;
    }

    public String getMapComponent() {
        return mapComponent;
    }

    public static String getMapComponent(int number) {
        return values()[number].mapComponent;
    }

    public static boolean isBadMapComponent(String query) {
        return mapComponents.get(query) == null;
    }

    private static final Map<String, MapComponentType> mapComponents =
            Arrays.stream(MapComponentType.values())
                    .collect(Collectors.toUnmodifiableMap(MapComponentType::getMapComponent, Function.identity()));
}
