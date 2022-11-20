package bridge.model.map;

import java.util.ArrayList;
import java.util.List;

public class Columns {
    private final List<Column> columns = new ArrayList<>();

    public Columns add(Column column) {
        columns.add(column);
        return this;
    }

    public String upperRow() {
        StringBuilder row = new StringBuilder();
        for (Column column : columns) {
            row.append(column.up);
        }
        return row.toString();
    }

    public String lowerRow() {
        StringBuilder row = new StringBuilder();
        for (Column column : columns) {
            row.append(column.down);
        }
        return row.toString();
    }
}
