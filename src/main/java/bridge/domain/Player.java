package bridge.domain;

import bridge.type.PositionType;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<PositionType> positions;

    public Player() {
        this.positions = new ArrayList<>();
    }

    // 문자열을 받아 PositionType 으로 매핑
    public void selectPosition(String readMove) {
        PositionType matchPosition = PositionType
                .matchSymbol(readMove)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] PositionType is not match !!"));

        this.positions.add(matchPosition);
    }

    public PositionType currentPosition(int start) {
        return positions.get(start);
    }

    public void removePositions() {
        this.positions.clear();
    }
}
