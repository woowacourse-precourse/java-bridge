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

    BridgeGame(List<String> bridge){
        this.bridge = bridge;
        this.playerCurrentDirection = "";
        this.playerCurrentStep = 0;
        this.totalAttempts = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        playerCurrentDirection = direction;
        playerCurrentStep++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        playerCurrentStep = 0;
        totalAttempts++;
    }

    public boolean checkBridgeAndPlayer(){
        String safeDirection = bridge.get(playerCurrentStep - 1);

        return safeDirection.equals(playerCurrentDirection);
    }

    public boolean isEndOfBridge(){
        return playerCurrentStep >= bridge.size();
    }

    public int getTotalAttempts(){
        return totalAttempts;
    }
}
