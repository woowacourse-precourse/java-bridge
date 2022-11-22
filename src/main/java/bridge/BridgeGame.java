package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.GameStatus.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> answerBridge;
    private List<String> curBridge;
    private int stageNum;
    private GameStatus status;

    BridgeGame(int size){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        this.answerBridge = bridgeMaker.makeBridge(size);
        this.curBridge = new ArrayList<>();
        this.stageNum = 1;
        this.status = STATUS_PLAY;
    }

    public GameStatus getStatus(){
        return this.status;
    }

    public void move(String moving) {
        curBridge.add(moving);
        compareMoving();

    }
    private void compareMoving(){
        int idx = curBridge.size();
        if(!answerBridge.get(idx-1).equals(curBridge.get(idx-1))){
            this.status = STATUS_FAIL;
        }
        if(answerBridge.size() == idx){
            this.status = STATUS_SUCCESS;
        }
    }


    public void retry() {
        this.stageNum += 1;
        this.curBridge.clear();
    }
}
