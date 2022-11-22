package bridge.Service;

import bridge.BridgeRandomNumberGenerator;
import bridge.Utils.BridgeMaker;
import bridge.Domain.Judgement;
import bridge.Domain.Record;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private List<String> bridge;
    private final Record movingRecord;
    private final Judgement judgement;

    BridgeGame() {
        movingRecord = new Record();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        judgement = new Judgement();
    }

    public void setBridge(int size){
        this.bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movingDirection) {
        movingRecord.addMoving(movingDirection);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean checkRetry(String RetryInput){
        return RetryInput.equals("R");
    }
    public boolean checkArrival(){
        return judgement.checkArrival(movingRecord,bridge);
    }
    public boolean checkPlay(String movingDirection){
        move(movingDirection);
        movingRecord.printMap(bridge);
        if (checkArrival()) return false;
        return judgement.checkSameDirection(movingRecord,movingDirection,bridge);
    }

    public void retry() {
        movingRecord.addRetryCount();
        movingRecord.reset();
    }

    public void printResult() {
        movingRecord.printResult(bridge,checkArrival());
    }
}
