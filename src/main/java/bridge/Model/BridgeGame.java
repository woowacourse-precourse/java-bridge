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
    private int position;

    public BridgeGame(List<String> bridge, List<ChoiceDirection> choiceDirections, List<CrossResult> crossResults) {
        this.choiceDirections = new ChoiceDirections(choiceDirections);
        this.crossResults = new CrossResults(crossResults);
        this.bridge = new Bridge(bridge);
        this.tryCount = 1;
        this.position = initPosition();
    }

    public void move(ChoiceDirection choiceDirection) {
        position++;
        CrossResult crossResult = bridge.cross(choiceDirection, position);
        choiceDirections.add(choiceDirection);
        crossResults.add(crossResult);
    }

    public GameStatus checkGameStatus() {
        GameStatus status = GameStatus.RUNNING;
        if (bridge.isEndPoint(position)) {
            status = GameStatus.SUCCESS;
        }
        if (crossResults.isFailed()) {
            status = GameStatus.FAIL;
        }
        return status;
    }

    public void retry() {
        choiceDirections = new ChoiceDirections(new ArrayList<>());
        crossResults = new CrossResults(new ArrayList<>());
        position = initPosition();
        tryCount++;
    }

    private int initPosition(){
        return choiceDirections.length() - 1;
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
