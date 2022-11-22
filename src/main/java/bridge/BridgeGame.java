package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridgeList ;
    private int count;
    private int tryCount;
    public BridgeGame(List<String> bridgeList){
        this.bridgeList = bridgeList;
        count = 0;
        tryCount=1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BirdgeMoveType move(String moveWay) {

        if(bridgeList.get(count).equals(moveWay)){
            count+=1;
            if(moveWay.equals("U")) return BirdgeMoveType.upGoMovement;

            if (moveWay.equals("D")) return BirdgeMoveType.downGoMovement;
        }
        if (!bridgeList.get(count).equals(moveWay)) {
            if (moveWay.equals("U")) return BirdgeMoveType.upStopMovement;

            if (moveWay.equals("D")) return BirdgeMoveType.downStopMovement;
        }

        throw new IllegalArgumentException("[ERROR] U / D 로 입력해주세요");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount+=1;
        count=0;
    }

    public int getTryCount(){
        return tryCount;
    }
}
