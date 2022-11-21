package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.DownBridgeRendering;
import bridge.model.UpsideBridgeRendering;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static Bridge bridge;

    public void createBridge() {
        int bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int position) {
        String moving = inputView.readMoving();
        boolean success = false;
        if (moving.equals(bridge.getShape(position))) {
            success = true;
        }
        bridge.setUpsideBridge(UpsideBridgeRendering.renderUpsideBridge(moving, success));
        bridge.setDownBridge(DownBridgeRendering.renderDownBridge(moving, success));
        outputView.printMap(bridge);
        return success;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            bridge.clear();
            return true;
        }
        return false;
    }
}
