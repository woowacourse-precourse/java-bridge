package bridge.domain;

import bridge.domain.model.Direction;
import bridge.domain.model.GameStatus;
import bridge.domain.model.PieceMove;

import java.util.Stack;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Stack<PieceMove> moveTrace = new Stack<>();
    private GameStatus status = GameStatus.RUNNING;
    private int trialCount = 1;

    /**
     * 게임을 생성
     * @param bridge 다리 정보 (이후 변경할 수 없음)
     */
    public BridgeGame(final Bridge bridge) {
        this.bridge = bridge;
    }

    /**
     * 다리의 다음 칸에서 원하는 방향으로 이동
     * @param direction 이동할 방향
     * @throws IllegalStateException 더 이상 이동할 수 없는 상황일 때 예외 발생
     */
    public void move(Direction direction) throws IllegalStateException {
        checkStatusValidation();
        boolean allowed = bridge.isAllow(moveTrace.size(), direction);
        moveTrace.add(new PieceMove(direction, allowed));
        updateStatus();
    }

    /**
     * 게임의 상태를 반환
     * @return 상태 정보
     * @see GameStatus
     */
    public GameStatus getStatus() {
        return this.status;
    }

    /**
     * 누적된 이동 결과를 이용해 다리를 출력 가능하도록 반환
     * <p>
     * 다리 출력 방법에 대한 구현체 필요
     * @param translator 다리 출력 구현체
     * @return 출력 가능한 형태의 다리 모습
     * @see BridgeTranslator
     */
    public String getPrintable(BridgeTranslator translator) {
        return translator.getPrintable(this.moveTrace);
    }

    /**
     * 총 시도 횟수 반환
     * @return 총 시도 횟수
     */
    public int getTrialCount() {
        return this.trialCount;
    }

    /**
     * 이동할 수 있는 상태인지 검증
     * @throws IllegalStateException 승리나 실패한 후 이동 시 예외 발생
     */
    private void checkStatusValidation() throws IllegalStateException {
        if (this.status != GameStatus.RUNNING) {
            throw new IllegalStateException();
        }
    }

    /**
     * 현재 게임 상태를 갱신
     * @see #getCurrentStatus()
     */
    private void updateStatus() {
        if (moveTrace.isEmpty()) {
            return;
        }
        this.status = getCurrentStatus();
    }

    /**
     * 승리 또는 실패를 파악하고 현재 상태 반환
     * @return 현재 상태
     */
    private GameStatus getCurrentStatus() {
        if (!moveTrace.peek().getSuccess()) {
            return GameStatus.LOSE;
        }
        if (moveTrace.size() == bridge.getNumOfCells()) {
            return GameStatus.WIN;
        }
        return GameStatus.RUNNING;
    }


    /**
     * 게임을 재시작할 때 사용
     * <p>
     * 맵은 초기화되지 않으며, 시도 횟수를 증가시킨다.
     */
    public void retry() {
        status = GameStatus.RUNNING;
        trialCount++;
        moveTrace.clear();
    }
}
