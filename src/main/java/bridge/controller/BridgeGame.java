package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeNumberGenerator bridgeNumberGenerator;
    private Bridge bridge;

    public void start(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        init();
        while (isGameDone()) {
            move();
        }
    }

    private void init() {
        OutputView.startBridgeGame();
        int size = readBridgeSize();
        List<String> bridges = makeBridge(size);
        this.bridge = new Bridge(size, bridges);
    }

    private int readBridgeSize() {
        try {
            OutputView.readBridgeSize();
            int size = InputView.readBridgeSize();
            return size;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readBridgeSize();
        }
    }

    private List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        OutputView.readMoving();
        String moving = InputView.readMoving();
        bridge.updateLocation(moving);
        OutputView.printMap();
    }

    private boolean isGameDone() {
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
