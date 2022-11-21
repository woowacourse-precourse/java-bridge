package bridge.service;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.AfterMovingStatusConstant;
import bridge.constant.UpDownConstant;
import bridge.domain.Bridge;
import bridge.repository.BridgeMaker;
import bridge.validation.Validation;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static BridgeGame bridgeGame;
    private final List<String> bridge = new ArrayList<>();
    private final Validation validation = new Validation();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    protected BridgeGame() {

    }

    public static BridgeGame getBridgeGame() {
        if (bridgeGame == null) {
            return new BridgeGame();
        }
        return bridgeGame;
    }

    public List<String> createBridge(String length) {
        validation.bridgeLengthValidation(length);
        this.bridge.addAll(bridgeMaker.makeBridge(Integer.parseInt(length)));
        return this.bridge;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public AfterMovingStatusConstant move(Bridge randomCreateBridge, Bridge thisTurnBridge, String upOrDownInput) {
        validation.bridgeMovingValidation(upOrDownInput);
        thisTurnBridge.addBridge(UpDownConstant.of(upOrDownInput));
        if (thisTurnBridge.equals(randomCreateBridge, thisTurnBridge.length() - 1)) {
            if (thisTurnBridge.equalsLength(randomCreateBridge)) {
                return AfterMovingStatusConstant.SUCCESS;
            }
            return AfterMovingStatusConstant.NEXT_TURN;
        }
        return AfterMovingStatusConstant.FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
