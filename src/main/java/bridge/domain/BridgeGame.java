package bridge.domain;

import bridge.constants.Command;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final HashMap<String, StringBuilder> bridgeState;

    public BridgeGame(HashMap<String, StringBuilder> bridgeState) {
        this.bridgeState = bridgeState;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type),
     * 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
     */
    public HashMap<String, StringBuilder> move(String playerMoving, String bridgeJudgment) {
        if (playerMoving.equals("U") && bridgeJudgment.equals("O")) {
            bridgeState.get(0).append(bridgeJudgment);
            bridgeState.get(1).append(" ");
        }

        if (playerMoving.equals("U") && bridgeJudgment.equals("X")) {
            bridgeState.get(0).append(bridgeJudgment);
            bridgeState.get(1).append(" ");
        }

        if (playerMoving.equals("D") && bridgeJudgment.equals("O")) {
            bridgeState.get(0).append(" ");
            bridgeState.get(1).append(bridgeJudgment);
        }

        if (playerMoving.equals("D") && bridgeJudgment.equals("X")) {
            bridgeState.get(0).append(" ");
            bridgeState.get(1).append(bridgeJudgment);
        }

        return bridgeState;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    // TODO: 작성하기.
    public void retry() {

    }
}
