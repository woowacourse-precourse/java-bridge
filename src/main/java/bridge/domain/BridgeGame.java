package bridge.domain;

import java.util.List;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int currentBridgeIndex;
    private int count;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        currentBridgeIndex = 0;
        count = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getCurrentBridgeIndex() {
        return currentBridgeIndex;
    }

    public int getCount() {
        return count;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(MoveCommand moveCommand) {
        String command = moveCommand.getCommand();
        String currentBridgeState = bridge.get(currentBridgeIndex++);

        return command.equals(currentBridgeState);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(GameCommand command) {
        if (command.equals(GameCommand.REPLAY)) {
            count++;
            currentBridgeIndex = 0;
            return true;
        }
        return false;
    }
}
