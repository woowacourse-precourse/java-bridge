package bridge;

import java.util.List;

import bridge.controller.InputController;
import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private final Bridge bridge;
    private final Player player;
    private final InputController inputController;

    public BridgeGame(Bridge bridge, Player player, InputController inputController) {
        this.bridge = bridge;
        this.player = player;
        this.inputController =inputController;
    }

    public void move(int bridgeSize) {
        for (int trialNum = 0; trialNum < bridgeSize; trialNum++) {
            Movement movementInput = inputController.getDirection();
            player.updateMovement(movementInput);
            if (!checkAnswer(player.getDistance())) {
                break;
            }
        }
    }

    private boolean checkAnswer(int distance) {
        List<String> bridgeValues = bridge.getBridge();
        List<Movement> playerRoute = player.getRoute();
        for (int i = 0; i < distance; i++ ) {
            if (!bridgeValues.get(i).equals(playerRoute.get(i).getDirection())) {
                return false;
            }
        }
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
