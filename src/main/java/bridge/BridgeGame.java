package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private String playerCurrentDirection;
    private int playerCurrentStep;
    private int totalAttempts;

    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.playerCurrentDirection = "";
        this.playerCurrentStep = 0;
        this.totalAttempts = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 사용자의 방향입력을 사용자 현재 방향값으로 설정하며 한 칸 앞으로 가게 한다.
     */
    public void move(String direction) {
        playerCurrentDirection = direction;
        playerCurrentStep++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 사용자 현재 위치(칸 수)를 초기화하고 게임 시도횟수를 늘린다.
     */
    public void retry() {
        clearPlayerCurrentStep();
        totalAttempts++;
    }

    /**
     * @return 현재 사용자의 방향과 실제 안전한 방향을 비교하여 반환
     */
    public boolean checkBridgeAndPlayer() {
        String safeDirection = bridge.get(playerCurrentStep - 1);

        return safeDirection.equals(playerCurrentDirection);
    }

    /**
     * @return 사용자가 다리의 마지막에 왔는지 확인하여 반환
     */
    public boolean isEndOfBridge() {
        return playerCurrentStep >= bridge.size();
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public void clearPlayerCurrentStep() {
        this.playerCurrentStep = 0;
    }
}
