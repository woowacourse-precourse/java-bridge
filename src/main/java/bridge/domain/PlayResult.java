package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayResult {

    private final List<MoveStatus> playResult = new ArrayList<>();

    public void updateResult(String spaceToMove, boolean canGo) {
        playResult.add(MoveStatus.findBySpaceToMove(spaceToMove, canGo));
    }
}
