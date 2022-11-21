package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private List<String> gameState;
    int count;      // 입력 개수
    private boolean isSuccess;
    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        isSuccess = false;
        gameState = new ArrayList<>();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param crossTheBridge : U or D
     * @return O (true) , X (false)
     */
    public boolean move(String crossTheBridge) {
        if(bridge.get(count).equals(crossTheBridge)){
            if(endOfInput()) {
                return true;
            }
            return false;
        }
        return crossFail(crossTheBridge);
    }
    // 건너기 실패 (종료)
    public boolean crossFail(String crossTheBridge){
        gameState.add(crossTheBridge);
        isSuccess = false;
        return false;
    }
    // 사용자의 최대 입력 ( 다리의 총 개수) 만큼 입력하였을 때
    public boolean endOfInput(){
        gameState.add(bridge.get(count));
        count++;
        isSuccess = true;
        if(bridge.size() == count) {
            // 게임 승리 (종료)
            return false;
        }
        // 게임 계속 진행
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     */
    public boolean retry(String whetherRetryGame) {
        if(whetherRetryGame.equals("R")){
            return true;
        }
        if(whetherRetryGame.equals("Q")){
            return false;
        }
        return false;
    }

    // 게임 상황을 반환해주는 메서드
    public List<String> getGameState() {
        return gameState;
    }
    // 성공 여부를 반환하는 getter
    public boolean getIsSuccess(){
        return isSuccess;
    }
}
