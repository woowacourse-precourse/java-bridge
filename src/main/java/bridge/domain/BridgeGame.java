package bridge.domain;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final BridgeGameStatus bridgeGameStatus = new BridgeGameStatus();

    public BridgeGame(Bridge bridge) {
        init();
        this.bridge = bridge;
    }

    private void init() {
        bridgeGameStatus.initGame();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Answer move(BridgeDirection direction) {
        Answer answer = bridge.canMove(bridgeGameStatus.getPosition(), direction);
        if (answer.isCorrect()) {
            return moveSuccess();
        }
        return moveFail();
    }

    private Answer moveSuccess() {
        bridgeGameStatus.increasePosition();

        if (bridge.isEnd(bridgeGameStatus.getPosition())) {
            bridgeGameStatus.success();
        }
        return Answer.RIGHT;
    }

    private Answer moveFail() {
        bridgeGameStatus.fail();
        return Answer.WRONG;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeGameStatus.increaseTryCount();
        init();
    }

    public boolean isPlaying() {
        return getStatus() == GameStatus.PLAYING;
    }

    public GameStatus getStatus() {
        return bridgeGameStatus.getGameStatus();
    }

    public int getTryCount() {
        return bridgeGameStatus.getTryCount();
    }

    public boolean isFail() {
        return getStatus() == GameStatus.FAIL;
    }
}
