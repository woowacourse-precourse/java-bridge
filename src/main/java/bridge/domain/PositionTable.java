package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PositionTable {
    private List<Position> positionTable;

    private PositionTable() {
        positionTable = new ArrayList<>();
    }

    public static PositionTable newInstance() {
        return new PositionTable();
    }

    public void add(Position position) {
        positionTable.add(position);
    }
    public boolean matchLastOf(PositionTable userTable) {
        int userLastIndex = userTable.lastIndex();
        Position userLastPosition = userTable.lastPosition();
        return positionTable.get(userLastIndex).equals(userLastPosition);
    }

    private Position lastPosition() {
        return positionTable.get(lastIndex());
    }

    private int lastIndex() {
        return positionTable.size() - 1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionTable that = (PositionTable) o;
        return Objects.equals(positionTable, that.positionTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionTable);
    }

    public List<Position> getTable() {
        return positionTable;
    }

    public int size() {
        return positionTable.size();
    }
}
