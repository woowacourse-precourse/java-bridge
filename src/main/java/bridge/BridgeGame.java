package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int gameTryCount;

    public BridgeGame() {
        gameTryCount = 1;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        checkGameTryCountOverIntegerMaxValue();
        gameTryCount++;
    }

    public void checkGameTryCountOverIntegerMaxValue() {
        if(gameTryCount == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] 너무 많은 게임 시도는 건강에 해롭습니다. 게임을 종료합니다.");
        }
    }

    public int getGameTryCount() {
        return gameTryCount;
    }
}
