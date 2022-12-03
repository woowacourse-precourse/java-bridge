package bridge.model.map;

import bridge.model.RoundStatus;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<RoundStatus> map;

    private Map() {
        this.map = new ArrayList<>();
    }

    public static Map create() {
        return new Map();
    }
}
