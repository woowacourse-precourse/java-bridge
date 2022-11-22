package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final int INIT_TRY_COUNT = 1;
    public static final int INIT_BRIDGE_INDEX = 0;
    public static final String RETRY = "R";

    private final List<String> answerBridge;
    private BridgeMap bridgeMap;
    private GameStatus gameStatus;
    private int bridgeIndex;
    private int tryCount;

    public BridgeGame(List<String> answerBridge) {
        this.answerBridge = answerBridge;
        init(INIT_TRY_COUNT);
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getResult() {
        return gameStatus.getStatus();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeMap move(String readMoving) {
        Move move = Move.of(readMoving);
        String answerRoom = answerBridge.get(bridgeIndex);

        if (answerRoom.equals(readMoving)) {
            return moveCorrectBridge(move);
        }

        return moveWrongBridge(move);
    }

    private BridgeMap moveCorrectBridge(Move move) {
        incrementCurrentPosition();
        bridgeMap.moveCorrectBridge(move);
        return bridgeMap;
    }

    public void incrementCurrentPosition() {
        bridgeIndex += 1;

        if (bridgeIndex == answerBridge.size()) {
            gameStatus = GameStatus.WIN;
        }
    }

    private BridgeMap moveWrongBridge(Move move) {
        gameStatus = GameStatus.FAIL;
        bridgeMap.moveWrongBridge(move);
        return bridgeMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String userCommand) {
        if (userCommand.equals(RETRY)) {
            init(tryCount + 1);
        }
    }

    public void init(int tryCount) {
        this.bridgeIndex = INIT_BRIDGE_INDEX;
        this.tryCount = tryCount;
        this.bridgeMap = new BridgeMap();
        this.gameStatus = GameStatus.PLAYING;
    }

    public boolean isGameOngoing() {
        return gameStatus == GameStatus.PLAYING;
    }

    public boolean isFail() {
        return gameStatus == GameStatus.FAIL;
    }
}
