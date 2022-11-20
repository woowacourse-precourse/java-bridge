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

    public BridgeGame(BridgeSize bridgeSize) {
        choiceDirections = new ChoiceDirections();
        crossResults = new CrossResults();
        bridge = new Bridge(makeBridge(bridgeSize));
        tryCount = 1;
    }

    private List<String> makeBridge(BridgeSize bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        int size = bridgeSize.getSize();
        return bridgeMaker.makeBridge(size);
    }

    public void move(ChoiceDirection choiceDirection) {
        CrossResult crossResult = bridge.cross(choiceDirection, crossResults.nextPosition());
        choiceDirections.add(choiceDirection);
        crossResults.add(crossResult);
    }

    public GameStatus checkGameStatus() {
        if (isEndPoint()) {
            return GameStatus.SUCCESS;
        }
        if (isFailed()) {
            return GameStatus.FAIL;
        }
        return GameStatus.RUNNING;
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
