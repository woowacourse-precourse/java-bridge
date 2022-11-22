package bridge;

import bridge.*;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static bridge.Player.bridges;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    GameSystem gameSystem;
    Player player;
    int trialNumber=1;
    private final AnswerBridge answerBridge;

    public BridgeGame(){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        answerBridge = new AnswerBridge(bridgeMaker.getBridgeSize());
        player = new Player(new Bridges(answerBridge.size));
        gameSystem = new GameSystem(player,answerBridge);
    }

    public void start(){
        Boolean moveSuccess;
        do{
            moveSuccess = move();
            System.out.println(trialNumber);
        } while((moveSuccess == false) && retry(gameSystem.retryOrNot()));
    }

   
}
