package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.GameStatus.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final String RIGHT = "O";
    private final String WRONG = "X";
    private final String NOTHING = " ";

    private final List<String> answerBridge;
    //private List<String> curBridge;;
    private List<List<String>> curBridge;
    private int stageNum;
    private GameStatus status;

    BridgeGame(int size){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> upper = new ArrayList<>();
        List<String> lower = new ArrayList<>();

        this.answerBridge = bridgeMaker.makeBridge(size);
        this.curBridge = List.of(upper, lower);
        this.stageNum = 1;
        this.status = STATUS_PLAY;
    }

    public List<List<String>> getCurBridge(){
        return this.curBridge;
    }

    public int getStageNum(){
        return this.stageNum;
    }
    public GameStatus getStatus(){
        return this.status;
    }

    public void move(String moving) {
        addCurBridge(moving);

        if(this.status != STATUS_FAIL){
            checkSuccess();
        }
    }

    private void addCurBridge(String moving){
        String isRight = compareCurMoving(moving);
        if(moving.equals("U")){
            curBridge.get(0).add(isRight);
            curBridge.get(1).add(NOTHING);
        }
        if(moving.equals("D")){
            curBridge.get(0).add(NOTHING);
            curBridge.get(1).add(isRight);
        }
    }
    private String compareCurMoving(String moving){
        String answer = answerBridge.get(curBridge.get(0).size());
        if(answer.equals(moving)){
            return RIGHT;
        }
        this.status = STATUS_FAIL;
        return WRONG;
    }

    private void checkSuccess(){
        if(this.answerBridge.size() == this.curBridge.get(0).size()) {
            this.status = STATUS_SUCCESS;
        }
    }

    public void retry() {
        this.status = STATUS_PLAY;;
        this.stageNum += 1;
        this.curBridge.get(0).clear();
        this.curBridge.get(1).clear();
    }
}
