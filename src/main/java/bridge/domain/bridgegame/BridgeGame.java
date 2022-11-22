package bridge.domain.bridgegame;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final StringBuilder upBridge;
    private final StringBuilder downBridge;
    private int gameTrialCount = 1;
    private boolean winOrLose = true;

    public BridgeGame() {
        upBridge = new StringBuilder();
        downBridge = new StringBuilder();
    }

    public GameStatus getGameStatus() {
        return new GameStatus(upBridge, downBridge, gameTrialCount, winOrLose);
    }

    public void reset() {
        winOrLose = true;
        upBridge.setLength(0);
        downBridge.setLength(0);
        gameTrialCount++;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movement, boolean isMatch, int index) {
        setFence(index);
        setWinOrLose(isMatch);
        if (movement.equals(BridgeType.UP_VALUE.getUpOrDown())) {
            upBridge.append(String.format("%s", UserChoice.findGame(true, isMatch).getGameValue()));
            downBridge.append(String.format("%s", UserChoice.findGame(false, isMatch).getGameValue()));
        }
        if (movement.equals(BridgeType.DOWN_VALUE.getUpOrDown())) {
            upBridge.append(String.format("%s", UserChoice.findGame(false, isMatch).getGameValue()));
            downBridge.append(String.format("%s", UserChoice.findGame(true, isMatch).getGameValue()));
        }
    }

    private void setWinOrLose(boolean isMatch) {
        if (!isMatch) {
            winOrLose = false;
        }
    }

    public void setFence(int index) {
        if (index > 0) {
            upBridge.append(" | ");
            downBridge.append(" | ");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        return Retry.findRetry(gameCommand).getRetryValue().equals(Retry.RESTART.getRetryValue());
    }
}
