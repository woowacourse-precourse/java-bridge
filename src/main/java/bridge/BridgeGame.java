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
        } while((moveSuccess == false) && retry(gameSystem.retryOrNot()));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean move() {
        for(int index=0;index<answerBridge.size;index++) {
            if(gameSystem.move(index) == false) return false;
        }
        finalResult(true);
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean retry(boolean retryOrNot) {
        if(retryOrNot == false) {
            finalResult(false);
            return false;
        }
        player.bridges = new Bridges(answerBridge.size);
        GameSystem gameSystem = new GameSystem(player,answerBridge);
        this.gameSystem = gameSystem;
        trialNumber++;
        return true;
    }
    public void finalResult(boolean moveSuccess){
        gameSystem.printResult(moveSuccess,trialNumber);
    }

}
