package bridge;

import bridge.Constant.GameStatus;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constant.Command.*;
import static bridge.Constant.GameStatus.*;

public class BridgeGame {
    private final String RIGHT = "O";
    private final String WRONG = "X";
    private final String NOTHING = " ";
    private final int UP_LINE = 0;
    private final int DOWN_LINE = 1;

    private final List<String> answerBridge;
    private List<List<String>> curBridge;
    private int stageNum;
    private GameStatus status;

    BridgeGame(int size){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();

        this.answerBridge = bridgeMaker.makeBridge(size);
        this.curBridge = List.of(up,down);
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
        addCurMoving(moving);

        if(this.status != STATUS_FAIL){
            checkSuccess();
        }
    }

    private void addCurMoving(String moving){
        String isRight = compareCurMoving(moving);
        if(moving.equals(UP)){
            curBridge.get(UP_LINE).add(isRight);
            curBridge.get(DOWN_LINE).add(NOTHING);
        }
        if(moving.equals(DOWN)){
            curBridge.get(UP_LINE).add(NOTHING);
            curBridge.get(DOWN_LINE).add(isRight);
        }
    }
    private String compareCurMoving(String moving){
        String answer = answerBridge.get(curBridge.get(UP_LINE).size());
        if(answer.equals(moving)){
            return RIGHT;
        }
        this.status = STATUS_FAIL;
        return WRONG;
    }

    private void checkSuccess(){
        if(this.answerBridge.size() == this.curBridge.get(UP_LINE).size()) {
            this.status = STATUS_SUCCESS;
        }
    }

    public void retry() {
        this.status = STATUS_PLAY;;
        this.stageNum += 1;
        this.curBridge.get(UP_LINE).clear();
        this.curBridge.get(DOWN_LINE).clear();
    }
}
