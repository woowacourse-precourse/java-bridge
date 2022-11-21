package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int bridgeSize;
    private final MoveResultJudgement moveResultJudgement;
    public BridgeGame(int readBridgeSize) {
        try {
            ValidationUtil.bridgeSizeValidation(readBridgeSize);
        }catch (IllegalArgumentException err){
            System.out.println(err);
        }
        this.bridgeSize = readBridgeSize;
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        this.moveResultJudgement = new MoveResultJudgement(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public boolean move(String moving) {
        return moveResultJudgement.movedResult(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String moving) {
        return true;
    }

    public boolean isGameComplete(String moving) {
        return moveResultJudgement.isGameComplete(moving);
    }
}
