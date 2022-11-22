package bridge.domain.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.constant.BridgeDirection;
import bridge.domain.constant.CrossingState;
import bridge.domain.model.GameRecordGenerator;
import bridge.domain.model.GameRecordMaker;
import bridge.domain.model.GameAgent;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int ZERO = 0;
    private static final int COUNT = 1;
    private final GameAgent gameAgent;
    private final GameRecordGenerator gameRecordGenerator;
    private GameRecordMaker gameRecordMaker;
    private int numberOfTrial;
    private int currentBridgeLocation;
    private boolean gameState;
    private int bridgeLength;

    private boolean restartState;

    public BridgeGame() {
        this.bridgeLength = ZERO;
        gameAgent = new GameAgent();
        gameRecordGenerator = new GameRecordGenerator();
        this.numberOfTrial = ZERO;
    }

    public void prepare() {
        this.restartState = false;
        this.gameState = true;
        this.currentBridgeLocation = ZERO;
        this.gameRecordMaker = new GameRecordMaker();
    }

    public void constructBridge(int bridgeLength) {
        this.bridgeLength = bridgeLength;
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeMade = bridgeMaker.makeBridge(bridgeLength);

        gameAgent.initialize(bridgeMade);
    }

    public void move(String playerWantToGo) {
        gameState &= gameAgent.checkPossibleToCross(playerWantToGo, currentBridgeLocation);
        ++currentBridgeLocation;
    }

    public String makeReport(BridgeDirection playerDirection) {
        List<String> currentCrossedResult = gameRecordGenerator.generate(gameState, playerDirection);
        gameRecordMaker.updateCurrentRecord(currentCrossedResult);
        gameRecordMaker.updateResult();
        return gameRecordMaker.getRecord();
    }

    public String getFinalResult() {
        return gameRecordMaker.getRecord();
    }

    public void updateTotalCount() {
        numberOfTrial += COUNT;
    }

    public int getTotalTrial() {
        return numberOfTrial;
    }

    public boolean isCrossSuccess() {
        return gameState;
    }

    public void Restart(boolean restartState) {
        this.restartState = restartState;
    }

    public boolean getRestartState() {
        return restartState;
    }

    public String getBridgeGameState() {
        return CrossingState.getSuccessOrNot(gameState);
    }

    public boolean isGameEnd() {
        return currentBridgeLocation < bridgeLength;
    }


}
