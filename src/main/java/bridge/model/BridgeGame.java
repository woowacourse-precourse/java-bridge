package bridge.model;

import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;

    private final BridgeMoveLog bridgeMoveLog;

    private static final int DEFAULT = 0;

    private int tryCount = 1;

    private int movePosition = DEFAULT;

    public BridgeGame(List<String> bridge, BridgeMoveLog bridgeMoveLog) {
        this.bridge = bridge;
        this.bridgeMoveLog = bridgeMoveLog;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus move(BridgeType bridgeType) {
        GameStatus gameStatus = checkGameStatus(bridgeType);
        bridgeMoveLog.writeLog(bridgeType, gameStatus.getSafe());
        return judgeGameStatus(gameStatus);
    }

    private GameStatus judgeGameStatus(GameStatus gameStatus) {
        if (movePosition == bridge.size() && gameStatus == GameStatus.CROSSING) {
            return GameStatus.SUCCESS;
        }

        return gameStatus;
    }

    public Map<BridgeType, List<String>> getLog() {
        return bridgeMoveLog.getMoveLog();
    }

    public int getTryCount() {
        return tryCount;
    }

    private GameStatus checkGameStatus(BridgeType bridgeType) {
        String command = bridge.get(movePosition++);

        if (bridgeType.isEqualCommand(command)) {
            return GameStatus.CROSSING;
        }

        return GameStatus.FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        movePosition = DEFAULT;
        bridgeMoveLog.resetLog();
    }
}
