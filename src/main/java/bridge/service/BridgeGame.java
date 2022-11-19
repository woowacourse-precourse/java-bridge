package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.validator.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int BRIDGE_MIN_LENGTH = 3;
    private final int BRIDGE_MAX_LENGTH = 20;
    private final int COUNT_ZERO = 0;

    private final List<String> systemBridge;
    private List<String> userBridge = new ArrayList<>();
    private int totalAttempt = COUNT_ZERO;

    public BridgeGame(BridgeNumberGenerator generator, int bridgeSize) throws IllegalArgumentException{
        this.systemBridge = makeBridge(generator, bridgeSize);
        totalAttempt++;
    }

    private List<String> makeBridge(BridgeNumberGenerator generator, int bridgeSize) throws IllegalArgumentException{
        final BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        Validator.validateListLengthInRange(bridge, BRIDGE_MIN_LENGTH, BRIDGE_MAX_LENGTH);
        return bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String nextMove) {
        userBridge.add(nextMove);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}