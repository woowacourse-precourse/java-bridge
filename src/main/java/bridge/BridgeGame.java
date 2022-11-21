package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static bridge.Constants.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    List<String> bridgeList = new ArrayList<>();
    List<String> userMove = new ArrayList<>();
    List<String> moveResults = new ArrayList<>();
    int tryCount = 1;

    BridgeGame(int bridgeSize){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        this.bridgeList = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moving, int bridgeNum) {
        String bridgeMove = bridgeList.get(bridgeNum);
        userMove.add(moving);
        if(moving.equals(bridgeMove)){
            moveResults.add(CAN_CROSS);
            return CAN_CROSS;
        }
        moveResults.add(CANNOT_CROSS);
        return CANNOT_CROSS;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String command, int bridgeSize){
        if(command.equals(RETRY)){
            //TODO: 재시도
            userMove.clear();
            moveResults.clear();
            tryCount++;
            bridgeSize = 0;
            return bridgeSize;
        }
        //TODO: 종료
        return bridgeSize;
    }

    public int getTryCount(){
        return tryCount;
    }

    public List<String> getBridgeList(){
        return bridgeList;
    }

    public List<String> getUserMove(){
        return userMove;
    }

    public List<String> getMoveResults(){
        return moveResults;
    }

}
