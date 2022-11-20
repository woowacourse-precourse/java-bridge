package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final AnswerBridge answerBridge;
    private BridgeGameStatus gameStatus;

    public BridgeGame(AnswerBridge answerBridge) {
        this(answerBridge, BridgeGameStatus.gameStart());
    }

    public BridgeGame(AnswerBridge answerBridge, BridgeGameStatus gameStatus) {
        this.answerBridge = answerBridge;
        this.gameStatus = gameStatus;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(Round round, Direction direction) {
        MoveResult result = answerBridge.check(round, direction);
        checkGameOver(round, result);
        return result;
    }

    private void checkGameOver(Round round, MoveResult result) {
        if (answerBridge.isLastRound(round) || result.isFail()) {
            gameStatus = BridgeGameStatus.STOP;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.gameStatus = BridgeGameStatus.PLAY;
    }

    public boolean isPlayable() {
        return gameStatus.isPlayable();
    }
}
