package bridge.model.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.dto.Bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker BRIDGE_MAKER;
    private final Bridge BRIDGE;

    public BridgeGame(int bridgeSize) {
        this.BRIDGE_MAKER = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.BRIDGE = new Bridge(BRIDGE_MAKER.makeBridge(bridgeSize));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moveAnswer, int index) {
        if (isCorrectAnswer(moveAnswer, index)) {
            return "O";
        }
        return "X";
    }

    public boolean isCorrectAnswer(String moveAnswer, int index) {
        if (!BRIDGE.getBridge().get(index).equals(moveAnswer)) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryAnswer) {
        if (retryAnswer.equals("R")) {
            return true;
        }
        return false;
    }

    public Bridge getBridge() {
        return BRIDGE;
    }
}
