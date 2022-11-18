package bridge;

import static bridge.MessageUtil.INVALID_MOVE_CHOICE;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private int moveCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        moveCount = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    public boolean matches(String choice){
        if (!isValidChoice(choice)){
            throw new IllegalArgumentException(INVALID_MOVE_CHOICE.message);
        }
        return bridge.isEqualToChoice(moveCount, choice);
    }

    private boolean isValidChoice(String choice) {
        return choice.matches("^[UD]$");
    }

    public boolean hasCrossed(){
        return moveCount == bridge.getBridgeSize();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
