package bridge;

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

    public void move() {
        for (int trialNum = 0; trialNum < bridge.getBridgeSize(); trialNum++) {
            movePlayer();
            if (!checkAnswer()) {
                System.out.println("틀렸다 자식아");
                retry();
                break;
            }
            judgeTrue();
        }
    }

    private void movePlayer() {
        Movement movementInput = inputController.getDirectionInput();
        player.updateMovement(movementInput);
    }

    private boolean checkAnswer() {
        // 브릿지로 옮길까?
        if (!player.matchPlayerAndBridge(bridge)) {
            return false;
        }
        return true;
    }

    private void judgeTrue() {
        player.updateAnswer(Boolean.TRUE);
    }

    private void judgeFalse() {
        player.updateAnswer(Boolean.FALSE);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        System.out.println("한번 더 기회를 준다");
        judgeFalse();
        if (inputController.retryCommandInput()) {
            player.resetPlayer();
            move();
        }
    }
}
