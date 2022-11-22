package bridge;

import bridge.domain.Bridge;
import bridge.domain.Result;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private Result result;
    private int tryCount;

    public BridgeGame(){
        this.result=new Result();
        tryCount=1;
    }
    public void makeBridge(List<String> bridge){
        this.bridge=new Bridge(bridge);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(int index, String moving){
        String movingResult=bridge.getMoveResult(moving, index);
        result.addResult(moving, movingResult);
        return movingResult;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result=new Result();
        tryCount++;
    }
    public int getTryCount(){
        return tryCount;
    }
    public List<List<String>> getResult(){
        return result.getPlayResult();
    }
    public int getBridgeSize(){
        return bridge.getBridgeSize();
    }
}
