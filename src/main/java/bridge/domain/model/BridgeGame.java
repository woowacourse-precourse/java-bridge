package bridge.domain.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.constant.BridgeDirection;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final GameAgent gameAgent;
    private final RecordFormat recordFormat;
    private final GameRecord gameRecord;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(BridgeNumberGenerator numberGenerator) {
        gameAgent = new GameAgent();
        recordFormat = new RecordFormat();
        this.gameRecord = new GameRecord();
        bridgeMaker = new BridgeMaker(numberGenerator);
    }

    public void constructBridge(int bridgeLength) {

        List<String> bridgeMade = bridgeMaker.makeBridge(bridgeLength);

        gameAgent.initialize(bridgeMade);
    }

    public boolean move(String playerWantToGo, int trial) {
        return gameAgent.checkPossibleToCross(playerWantToGo, trial);
    }

    public String makeReport(boolean gameState, BridgeDirection playerDirection, boolean isFirstTrial) {

        recordFormat.generate(gameState, playerDirection);
        recordFormat.updateCurrentRecord(isFirstTrial);
        gameRecord.updateResult(recordFormat.getCurrentGameRecord());

        return gameRecord.getRecord();
    }

    public String getFinalResult() {
        return gameRecord.getRecord();
    }

    public void deleteRecord(){
        gameRecord.reset();
    }



}
