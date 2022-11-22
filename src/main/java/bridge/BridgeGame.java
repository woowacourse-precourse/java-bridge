package bridge;

import java.util.List;

import static bridge.Check.checkBridge;
import static bridge.Count.*;
import static bridge.GenerateMessage.addMessage;
import static bridge.GenerateMessage.resetMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, String step) {
        boolean check = checkBridge(step, bridge);
        if(check){
            increaseSteps();
            addMessage(true, step);
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
        increaseAttempt();
        resetSteps();
        resetMessage();
    }
}
