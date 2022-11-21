package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.constant.CrossingState;
import bridge.domain.model.GameRecordGenerator;
import bridge.domain.model.GameRecordMaker;
import bridge.domain.model.GameAgent;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int ZERO=0;
    private static final int COUNT=1;

    private GameAgent gameAgent;
    private GameRecordMaker gameRecordMaker;
    private GameRecordGenerator gameRecordGenerator;
    private int numberOfTrial;
    private int currentBridgeLocation;
    private boolean gameState;
    private int bridgeLength;
    public BridgeGame(){
        this.bridgeLength=ZERO;
        gameAgent=new GameAgent();
        gameRecordGenerator=new GameRecordGenerator();
        this.numberOfTrial=ZERO;
    }
    public void prepare(){
        this.currentBridgeLocation=ZERO;
        this.gameState=true;
        this.gameRecordMaker=new GameRecordMaker();
    }
    public void constructBridge(int bridgeLength){
        this.bridgeLength=bridgeLength;
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeMade = bridgeMaker.makeBridge(bridgeLength);

        gameAgent.initialize(bridgeMade);
    }

}
