package bridge.Model;

import bridge.Enum.CrossResult;
import bridge.Enum.GameStatus;
import bridge.Model.WrappingType.*;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private ChoiceDirections choiceDirections;
    private CrossResults crossResults;
    private final Bridge bridge;
    private int tryCount;

    public BridgeGame(List<String> bridge, List<ChoiceDirection> choiceDirections, List<CrossResult> crossResults) {
        this.choiceDirections = new ChoiceDirections(choiceDirections);
        this.crossResults = new CrossResults(crossResults);
        this.bridge = new Bridge(bridge);
        this.tryCount = 1;
    }

    public void move(ChoiceDirection choiceDirection) {
        CrossResult crossResult = bridge.cross(choiceDirection, crossResults.nextPosition());
        choiceDirections.add(choiceDirection);
        crossResults.add(crossResult);
    }

    public GameStatus checkGameStatus() {
        GameStatus status = GameStatus.RUNNING;
        if (bridge.isEndPoint(choiceDirections.length())) {
            status = GameStatus.SUCCESS;
        }
        if (isFailed(crossResults)) {
            status = GameStatus.FAIL;
        }
        return status;
    }

    private boolean isFailed(CrossResults crossResults) {
        return crossResults.contain(CrossResult.FAIL);
    }

    public void retry() {
        choiceDirections = new ChoiceDirections(new ArrayList<>());
        crossResults = new CrossResults(new ArrayList<>());
        increaseTryCount();
    }

    private void increaseTryCount() {
        tryCount++;
    }

    public ChoiceDirections getChoiceDirections() {
        return choiceDirections;
    }

    public CrossResults getCrossResults() {
        return crossResults;
    }

    public int getTryCount() {
        return tryCount;
    }
}
