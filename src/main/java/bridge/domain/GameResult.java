package bridge.domain;

import bridge.enums.MovingType;
import bridge.enums.ResultType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private List<String> upSideResult = new ArrayList<>();
    private List<String> downSideResult = new ArrayList<>();

    public List<String> getUpSideResult() {
        return Collections.unmodifiableList(upSideResult);
    }

    public List<String> getDownSideResult() {
        return Collections.unmodifiableList(downSideResult);
    }

    public void addGameResult(boolean isCorrect, PlayerMoving playerMoving) {
        if (Objects.equals(playerMoving.getMoving(), MovingType.valueOf("UP").getInitial())) {
            addUpSideResult(isCorrect);
            return;
        }
        if (Objects.equals(playerMoving.getMoving(), MovingType.valueOf("DOWN").getInitial())) {
            addDownSideResult(isCorrect);
        }
    }

    private void addUpSideResult(boolean isCorrect) {
        downSideResult.add(ResultType.valueOf("NOT_SELECT").getRepresentation());
        if (isCorrect) {
            upSideResult.add(ResultType.valueOf("CORRECT").getRepresentation());
            return;
        }
        upSideResult.add(ResultType.valueOf("WRONG").getRepresentation());
    }

    private void addDownSideResult(boolean isCorrect) {
        upSideResult.add(ResultType.valueOf("NOT_SELECT").getRepresentation());
        if (isCorrect) {
            downSideResult.add(ResultType.valueOf("CORRECT").getRepresentation());
            return;
        }
        downSideResult.add(ResultType.valueOf("WRONG").getRepresentation());
    }
}
