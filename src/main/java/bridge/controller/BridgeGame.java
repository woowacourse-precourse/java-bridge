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
        int bridgeSize = validateBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private int validateBridgeSize() {
        boolean validation = false;
        int bridgeSize = 0;
        while (!validation) {
            try {
                bridgeSize = inputView.readBridgeSize();
                validation = true;
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage);
            }
        }
        return bridgeSize;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int position) {
        String moving = validateMoving();
        boolean success = false;
        success = canCross(moving, position);
        bridge.setUpsideBridge(UpsideBridgeRendering.renderUpsideBridge(moving, success));
        bridge.setDownBridge(DownBridgeRendering.renderDownBridge(moving, success));
        outputView.printMap(bridge);
        return success;
    }

    private String validateMoving() {
        boolean validation = false;
        String moving = "";
        while(!validation) {
            try {
                moving = inputView.readMoving();
                validation = true;
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage);
            }
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String gameCommand = validateGameCommand();
        if (gameCommand.equals("R")) {
            bridge.clear();
            return true;
        }
        return false;
    }

    private String validateGameCommand() {
        boolean validation = false;
        String gameCommand = "";
        while (!validation) {
            try {
                gameCommand = inputView.readGameCommand();
                validation = true;
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage);
            }
        }
        return gameCommand;
    }

    public boolean canCross(String moving, int position) {
        if (moving.equals(bridge.getShape(position))) {
            return true;
        }
        return false;
    }

    public boolean complete(int position) {
        if (position >= bridge.length()) {
            return true;
        }
        return false;
    }

    public void gameExit(String successOrFail, int count) {
        outputView.printResult(bridge, successOrFail, count);
    }
}
