package bridge.domain;

import bridge.domain.type.MoveResultType;
import bridge.domain.type.RoundResultType;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static final int INIT_GAME_TRY_COUNT = 0;
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
    public RoundResultType move(String moveCommand) {// U : direction
        MoveResultType moveResultType = bridgeWalker.move(moveCommand);
        return RoundResultType.of(moveResultType, isClear());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameTryCount++;
        bridgeWalker.reset();
    }

    public String getMoveRecord() {
        return bridgeWalker.getMoveRecord();
    }

    public boolean isClear() {
        return bridgeWalker.isCrossAllStep();
    }

    public String getClearDescription() {
        String clearStatus = RoundResultType.FAIL.getDescription();
        if (isClear()) {
            clearStatus = RoundResultType.CLEAR.getDescription();
        }
        return String.format("게임 성공 여부: %s", clearStatus);
    }

    public String getGameTryCountDescription() {
        return String.format("총 시도한 횟수: %d", gameTryCount);
    }
}
