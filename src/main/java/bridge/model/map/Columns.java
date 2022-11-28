package bridge.model.map;

import bridge.model.bridge.Node;
import java.util.ArrayList;
import java.util.List;

public class Columns {
    private static final String START_OF_ROW = "[ ";
    private static final String END_OF_ROW = " ]";
    private static final String SEPARATOR = " | ";

    private final List<Column> columns = new ArrayList<>();

    public Columns add(Column column) {
        columns.add(column);
        return this;
    }
    private String rowOf(Node position) {

        StringBuilder row = new StringBuilder(positionOf(position, 0));
        for(int i = 1; i < columns.size(); i++)  {
            row.append(SEPARATOR);
            row.append(positionOf(position, i));
        }
        return START_OF_ROW + row + END_OF_ROW;
    }

    private String positionOf(Node position, int index) {
        if (position.equals(Node.UP)) {
            return columns.get(index).up;
        }
        return columns.get(index).down;
    }

    public String toString() {
        return rowOf(Node.UP) + "\n" + rowOf(Node.DOWN);
    }
}
