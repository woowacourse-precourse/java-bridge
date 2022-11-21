package bridge.Model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Enum.CrossResult;
import bridge.Enum.GameStatus;
import bridge.Model.WrappingType.*;

import java.util.List;

public class BridgeGame {
    private ChoiceDirections choiceDirections;
    private CrossResults crossResults;
    private Bridge bridge;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.choiceDirections = new ChoiceDirections();
        this.crossResults = new CrossResults();
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
        if (isEndPoint()) {
            status =  GameStatus.SUCCESS;
        }
        if (isFailed()) {
            status =  GameStatus.FAIL;
        }
        return status;
    }

    private boolean isEndPoint() {
        return bridge.length() - crossResults.nextPosition() == 0;
    }

    private boolean isFailed() {
        return crossResults.contain(CrossResult.FAIL);
    }

    public void retry() {
        choiceDirections = new ChoiceDirections();
        crossResults = new CrossResults();
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
