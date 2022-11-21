package bridge;

import bridge.constant.MoveResult;
import bridge.constant.NumberType;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeGameStat bridgeGameStat;
    private int countOfRound;

    public BridgeGame() {
        this.bridgeGameStat = new BridgeGameStat();
        this.countOfRound = NumberType.INITIALIZE_TO_ZERO.getValue();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(List<String> bridge, String player, int count) {
        String block = bridge.get(count);
        if (block.equals(player)) {
            return MoveResult.CAN_MOVE;
        }

        return MoveResult.CAN_NOT_MOVE;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.countOfRound = NumberType.INITIALIZE_TO_ZERO.getValue();
        this.bridgeGameStat.restart();
    }

    /**
     * 사용자가 게임을 종료할 때 사용하는 메서드
     */
    public void quit() {
        this.countOfRound = Integer.MAX_VALUE;
    }

    public boolean isCountOfRoundLessThan(int bridgeSize) {
        return this.countOfRound < bridgeSize;
    }

    public void checkGameWin(int bridgeSize) {
        if (this.countOfRound == bridgeSize - NumberType.ONE.getValue()) {
            this.bridgeGameStat.gameWin();
        }
    }

    public void nextRound() {
        this.countOfRound++;
    }

    public BridgeGameStat getBridgeGameStat() {
        return bridgeGameStat;
    }

    public int getCountOfRound() {
        return countOfRound;
    }
}
