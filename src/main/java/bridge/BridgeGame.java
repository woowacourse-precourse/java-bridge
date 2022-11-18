package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int playerPosition;
    private int playCount;

    public BridgeGame(List<String> bridge){
        this.bridge= new ValidateBridgeGame().validate(bridge);
        playerPosition=0;
        playCount=1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveTo) {
        if(bridge.get(playerPosition).equals(moveTo)){
            playerPosition++;
            return checkNotGoal();
        }
        return false;
    }

    private boolean checkNotGoal(){
        if(bridge.size()!=playerPosition){
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {//playerPosition을 0으로 만들면됨,playCount 1추가
    }
}
