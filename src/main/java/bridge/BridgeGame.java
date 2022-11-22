package bridge;

import java.util.List;

import static bridge.Message.INVALID_MOVE_INPUT;
import static bridge.Message.INVALID_RETRY_INPUT;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeState bridgeState;
    public BridgeGame(BridgeState bridgeState){
        this.bridgeState = bridgeState;
    }

    public void move(String input, List<String> bridge) {

        validateMove(input);

        if (input.equals(bridge.get(bridgeState.getNextIndex()))) {
            bridgeState.moveState(input);
        }

        bridgeState.moveState("X");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        validateRetry(input);

        if (input.equals("R")) {
            bridgeState.refreshState();
            return true;
        }

        return false;
    }

    private void validateMove(String input){

        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(INVALID_MOVE_INPUT);
        }
    }

    private void validateRetry(String input){
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(INVALID_RETRY_INPUT);
        }
    }
}
