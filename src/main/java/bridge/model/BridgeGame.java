package bridge.model;

import java.util.List;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int tryNumber;
    private int nowLocation;
    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
        this.tryNumber = 0;
        this.nowLocation = 0;
    }

    public boolean move(String input) {
        tryNumber++;
        if(input.equals(bridge.get(nowLocation))){
            nowLocation++;
            return true;
        }
        return false;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
