package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.service.BridgeService;
import bridge.util.OutputPharses;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private final BridgeService bridgeService;

    private Bridge bridge;

    int bridgeSize;
    int totalGameCount;

    public BridgeGame(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    /**
     * 다리 생성하는 함수
     * @param bridgeSize
     */
    public void setBridge(int bridgeSize) {
        bridge = bridgeService.makeBridge(bridgeSize);
    }

    public Bridge getBridge() {
        return bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void startGame() {
        outputView.printGameStartInfo();
        setBridgeSize();
        setBridge(bridgeSize);
    }

    public void setBridgeSize() {
        try {
            outputView.printInfo(OutputPharses.BRIDGE_LENGTH_MSG.getMsg());
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            setBridgeSize();
        }
    }
}
