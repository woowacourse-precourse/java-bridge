package bridge;

import bridge.type.PositionType;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<PositionType> positions;

    public Player() {
        this.positions = new ArrayList<>();
    }

    public void selectPosition(String readMove) {
        PositionType matchPosition = PositionType
                .matchSymbol(readMove)
                .orElseThrow(() -> new IllegalArgumentException());

        this.positions.add(matchPosition);
    }

    public PositionType currentPosition(int start) {
        return positions.get(start);
    }

    public List<PositionType> getPositions() {
        return positions;
    }
}
