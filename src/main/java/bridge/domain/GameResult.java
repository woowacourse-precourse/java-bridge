package bridge.domain;

import bridge.enums.MovingType;
import bridge.enums.ResultType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private List<Integer> upSideResult = new ArrayList<>();
    private List<Integer> downSideResult = new ArrayList<>();

    public List<Integer> getUpSideResult() {
        return Collections.unmodifiableList(upSideResult);
    }

    public List<Integer> getDownSideResult() {
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
        downSideResult.add(ResultType.valueOf("NOT_SELECT").getCode());
        if (isCorrect) {
            upSideResult.add(ResultType.valueOf("CORRECT").getCode());
            return;
        }
        upSideResult.add(ResultType.valueOf("WRONG").getCode());
    }

    private void addDownSideResult(boolean isCorrect) {
        upSideResult.add(ResultType.valueOf("NOT_SELECT").getCode());
        if (isCorrect) {
            downSideResult.add(ResultType.valueOf("CORRECT").getCode());
            return;
        }
        downSideResult.add(ResultType.valueOf("WRONG").getCode());
    }
}
