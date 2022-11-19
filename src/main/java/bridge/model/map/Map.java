package bridge.model.map;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<MapColumn> columns = new ArrayList<>();

    public Map add(MapColumn column) {
        columns.add(column);
        return this;
    }

    public String upperRow() {
        StringBuilder row = new StringBuilder();
        for (MapColumn column : columns) {
            row.append(column.up);
        }
        return row.toString();
    }

    public String lowerRow() {
        StringBuilder row = new StringBuilder();
        for (MapColumn column : columns) {
            row.append(column.down);
        }
        return row.toString();
    }
}
