package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static final int INIT_GAME_TRY_COUNT = 1;
    int gameTryCount;
    BridgeWalker bridgeWalker;

    public BridgeGame(BridgeWalker bridgeWalker) {
        this.bridgeWalker = bridgeWalker;
        this.gameTryCount = INIT_GAME_TRY_COUNT;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public RoundResult move(String moveCommand) {// U : direction
        MoveResult moveResult = bridgeWalker.move(moveCommand);
        boolean isClear = bridgeWalker.isCrossAllStep();
        return RoundResult.of(moveResult, isClear);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
