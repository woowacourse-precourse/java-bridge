package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.view.InputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private Bridge user;
    private int currentStage;
    private int attempts;

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;

    public BridgeGame(BridgeMaker bridgeMaker, InputView inputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
    }

    public void readBridgeSize() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        this.bridge = new Bridge(bridge, size);
        this.user = new Bridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String nextMoving = inputView.readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
