package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.GameStatus.STATUS_PLAY;

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

        int idx = curBridge.size();
        System.out.println(curBridge);

    }


    public void retry() {
        this.stageNum += 1;
        this.curBridge.clear();
    }
}
