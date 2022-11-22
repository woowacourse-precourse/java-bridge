package bridge.bridgeGame;

import java.util.List;
import java.util.function.Supplier;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String END_COMMAND = "Q";
    private final BridgeGameLog gameLog;
    private final List<String> bridges;

    private boolean isEnd;

    public BridgeGame(List<String> bridges) {
        this.gameLog = new BridgeGameLog();
        this.bridges = bridges;
    }

    public boolean isGameEnd() {
        return !isEnd && !bridges.isEmpty();
    }

    public BridgeGameLog getGameLog() {
        return gameLog;
    }

    public List<String> getBridges() {
        return bridges;
    }

    public void addLog(String command) {
        gameLog.addLog(command.equals(bridges.get(0)), command);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String command) {
        final boolean isMove = isMove(command);
        if (isMove) {
            bridges.remove(0);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command, Supplier<String> endCommandValue) {
        final boolean isMove = isMove(command);
        if (isMove) {
            return;
        }
        String endCommand = endCommandValue.get();
        if (endCommand.equals(END_COMMAND)) {
            isEnd = true;
        }
    }

    private boolean isMove(String command) {
        return bridges.get(0).equals(command);
    }
}
