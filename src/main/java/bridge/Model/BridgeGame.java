package bridge.Model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Enum.CrossResult;
import bridge.Enum.GameStatus;
import bridge.Model.VO.*;

import java.util.List;

public class BridgeGame {
    UserChoices userChoices;
    CrossResults crossResults;
    Bridge bridge;
    int tryCount;

    public BridgeGame(BridgeSize bridgeSize) {
        userChoices = new UserChoices();
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

    public void move(UserChoice userChoice) {
        CrossResult crossResult = bridge.cross(userChoice, crossResults.position());
        userChoices.add(userChoice);
        crossResults.add(crossResult);
    }

    public GameStatus checkGameStatus() {
        GameStatus status = GameStatus.RUNNING;
        if (isEndPoint()) {
            status = GameStatus.SUCCESS;
        }
        if (isFailed()) {
            status = GameStatus.FAIL;
        }
        return status;
    }

    private boolean isEndPoint() {
        return bridge.length() - crossResults.position() == 0;
    }

    private boolean isFailed() {
        return crossResults.contain(CrossResult.FAIL);
    }

    public void retry() {
        userChoices = new UserChoices();
        crossResults = new CrossResults();
        increaseTryCount();
    }

    private void increaseTryCount() {
        tryCount++;
    }

    public UserChoices getUserChoices() {
        return userChoices;
    }

    public CrossResults getCrossResults() {
        return crossResults;
    }

    public int getTryCount() {
        return tryCount;
    }
}
