package bridge.model.map;

import bridge.model.RoundStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Map {
    private final List<String> map;

    private Map() {
        this.map = new ArrayList<>();
    }

    public static Map create() {
        return new Map();
    }

    public void updateMap(RoundStatus roundStatus) {
        map.add(roundStatus.getDisplay());
    }

    public String getMap() {
        StringJoiner result = new StringJoiner(" | ", "[ ", " ]");
        for (String status : map) {
            result.add(status);
        }
        return result.toString();
    }
}
