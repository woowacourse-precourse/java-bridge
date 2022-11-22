package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeGameAnswer gameAnswer;
    private BridgeGameStatus gameStatus;

    public BridgeGame(BridgeGameAnswer gameAnswer) {
        this.gameAnswer = gameAnswer;
        gameStatus = BridgeGameStatus.gameStart();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(Round round, Move move) {
        MoveResult result = gameAnswer.check(round, move);
        checkGameQuit(round, result);
        return result;
    }

    private void checkGameQuit(Round round, MoveResult result) {
        if (gameAnswer.isLastRound(round) || result.isFail()) {
            gameStatus = BridgeGameStatus.QUIT;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.gameStatus = BridgeGameStatus.gameRestart();
    }

    public boolean isPlaying() {
        return gameStatus.isPlayStatus();
    }
}
