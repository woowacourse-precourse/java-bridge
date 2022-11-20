package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.MapMaker;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다. BridgeGame의 패키지는 변경할 수 있다.
     * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
     * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
     */
    private Bridge bridge;
    private PlayerSteps steps;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private int numberOfAttempts;
    private boolean end;

    public BridgeGame(int bridgeSize) {
        List<String> bridgePositions = bridgeMaker.makeBridge(bridgeSize);
        bridge = Bridge.of(bridgePositions);
        steps = new PlayerSteps(bridgeSize);
        numberOfAttempts = 1;
        end = false;
    }

    public boolean isEnd() {
        return end;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Node to) {
        steps.add(to);
    }

    public boolean lastStepMismatch() {
        return steps.isLastStepSameWithBridge(bridge);
    }

    public void quit() {
        end = true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        numberOfAttempts++;
        // TODO 사용자 입력 하나 지우기
    }

    public List<String> makeMap() {
        return MapMaker.make(bridge, steps);
    }

    private boolean succeed() {
        return steps.size() == bridge.size() && steps.isLastStepSameWithBridge(bridge);
    }

    public GameResult makeResult() {
        return new GameResult(makeMap(), succeed(), numberOfAttempts);
    }
}
