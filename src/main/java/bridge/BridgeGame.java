package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private BridgeMap bridgeMap;
    private int currentPosition;
    private int tryCount;
    private GameStatus gameStatus;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        init(1);
    }

    public void init(int tryCount) {
        this.currentPosition = 0;
        this.tryCount = tryCount;
        this.bridgeMap = new BridgeMap();
        this.gameStatus = GameStatus.CONTINUE;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeMap move(Move move) {
        if (move.equals(Move.from(bridge.get(currentPosition)))) {
            increaseCurrentPosition();
            bridgeMap.correctMove(move);
            return bridgeMap;
        }
        bridgeMap.wrongMove(move);
        gameStatus = GameStatus.LOSE;
        return bridgeMap;
    }

    private void increaseCurrentPosition() {
        currentPosition++;
        isWin();
    }

    private void isWin() {
        if (currentPosition == bridge.size()) {
            gameStatus = GameStatus.WIN;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(GameCommand gameCommand) {
        if (gameCommand.equals(GameCommand.RETRY)) {
            init(++tryCount);
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getTryCount() {
        return tryCount;
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }
}
