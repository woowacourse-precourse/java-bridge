package bridge;

import bridge.controller.BridgeController;
import bridge.domain.Bridge;
import bridge.domain.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeController bridgeController;

    public BridgeGame(BridgeController bridgeController) {
        this.bridgeController = bridgeController;
    }

    public void runGame() {
        bridgeController.showWelcome();
        Player player = setPlayer(buildBridge());
        move(player);
        controlEndPoint(player);
    }

    private void controlEndPoint(Player player) {
        if (isFinished(player)) {
            bridgeController.showResult(player);
        }

        if (!isFinished(player)) {
            String retryCommand = bridgeController.getWantToRetry();
            retry(player, retryCommand);
        }
    }

    private boolean isFinished(Player player) {
        return bridgeController.checkSuccess(player);
    }

    private Player setPlayer(Bridge bridge) {
        return bridgeController.makePlayer(bridge);
    }

    private Bridge buildBridge() {
        return bridgeController.makeBridge();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Player player) {
        bridgeController.startNewRound(player);

        while (bridgeController.canMove(player)) {
            bridgeController.makeStep(player);
            bridgeController.showProgress(player);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Player player, String retryCommand) {
        if (retryCommand.equals("R")) {
            move(player);
            controlEndPoint(player);
        }

        if (retryCommand.equals("Q")) {
            bridgeController.showResult(player);
        }
    }
}
