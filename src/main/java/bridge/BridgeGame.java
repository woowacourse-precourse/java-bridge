package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.Bridge;
import bridge.domain.BridgePassed;
import bridge.enumeration.GameCommand;
import bridge.service.BridgeGameService;

public class BridgeGame {

    private final BridgeGameController bridgeGameController;
    private BridgePassed bridgePassed;

    public BridgeGame() {
        this.bridgeGameController = new BridgeGameController(new BridgeGameService());
    }

    public Bridge makeBridge(int input) {
        return bridgeGameController.createBridge(input);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgePassed move(Bridge bridge, int index, String input) {
        String moving = input;
        bridgePassed = bridgeGameController.showBridgePassed(bridge, index, moving);
        return bridgePassed;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        String answer = input;
        return quit(answer);
    }

    public boolean quit(String answer) {
        if (answer.equals(GameCommand.QUIT.getCommand())) {
            return true;
        }
        return false;
    }

    public BridgePassed getBridgePassed() {
        return bridgePassed;
    }
}
