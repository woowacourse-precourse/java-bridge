package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    private List<MoveType> moveTypes = new ArrayList<>();
    private int tryCount = 0;

    public GameData() {
    }

    public void saveMove(String moveType) {
        if (MoveType.UP_TYPE.compareTo(moveType)) {
            moveTypes.add(MoveType.UP_TYPE);
        }

        if (MoveType.DOWN_TYPE.compareTo(moveType)) {
            moveTypes.add(MoveType.DOWN_TYPE);
        }
    }
}
