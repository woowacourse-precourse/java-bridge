package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int playerPlace;
    private boolean isCorrect;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge, String moving, MovingMap movingMap) {
        moveCorrect(bridge, moving);
        movingMap.putStatus(moving, isCorrect);
        playerPlace++;
    }

    public void moveCorrect(List<String> bridge, String moving) {
        isCorrect = bridge.get(playerPlace).equals(moving);
    }

    public boolean isGameOver(int bridgeSize, MovingMap movingMap) {
        return (playerPlace == bridgeSize) && (movingMap.isLastStepCorrect()) ;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(MovingMap movingMap) {
        playerPlace = 0;
        movingMap.clear();
    }
}
