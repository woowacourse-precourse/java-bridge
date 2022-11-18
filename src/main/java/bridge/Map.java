package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private List<String> map;

    public Map() {
        this.map = initializeMap();
    }

    private List<String > initializeMap() {
        final String MAP_BEGINNING = "[ ";

        List<String> map = new ArrayList<>(
                Arrays.asList(MAP_BEGINNING, MAP_BEGINNING)
        );

        return map;
    }
}
