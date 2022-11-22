package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int currentBridge = -1;
    private int countPlayGame = 1;
    private boolean gameOver = false;

    public BridgeGame(final List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(PropertyMove property) {
        int nextBridge = currentBridge + 1;
        checkNextBridge(nextBridge);
        if (!bridge.get(nextBridge).equals(property.getValue())) {
            gameOver = true;
            return false;
        }
        currentBridge = nextBridge;
        return true;
    }

    private void checkNextBridge(final int nextBridge) {
        if (bridge.size() <= nextBridge) {
            throw new IllegalStateException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if (!gameOver) {
            throw new IllegalStateException();
        }
        gameOver = false;
        currentBridge = -1;
        countPlayGame++;
    }

    public int getCountPlayGame() {
        return countPlayGame;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getCurrentBridge() {
        return currentBridge;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isSuccessEndGame() {
        return bridge.size() - 1 == currentBridge;
    }
}
