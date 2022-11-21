package bridge;

import java.util.List;

import static bridge.Check.checkBridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    
    private static InputView inputView;
    private static GenerateMessage generateMessage;
    private static EndGame endGame;
    private static OutputView outputView;
    private static Count count;
    
    
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge) {
        String step = inputView.readMoving();
        boolean check = checkBridge(step, bridge);
        return check;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        count.increaseAttempt();
        count.resetSteps();
        generateMessage.reset();
    }
}
