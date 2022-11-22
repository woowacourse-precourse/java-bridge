package bridge;

import bridge.view.InputView;

import static bridge.view.InputView.D_INPUT_CLIPPED_WORD;
import static bridge.view.InputView.U_INPUT_CLIPPED_WORD;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, PlayerStatus playerStatus) {
        String direction = playerStatus.getDirection();
        boolean isMatch = playerStatus.isMatch();

        if (direction.equals(U_INPUT_CLIPPED_WORD)) {
            moveUpper(bridge, isMatch);
            return;
        }
        if (direction.equals(D_INPUT_CLIPPED_WORD)) {
            moveLower(bridge, isMatch);
        }
    }

    private void moveUpper(Bridge bridge, boolean isMatch) {
        if (isMatch) {
            bridge.moveUpperBridge();
            return;
        }
        bridge.cannotMoveUpperBridge();
    }

    private void moveLower(Bridge bridge, boolean isMatch) {
        if (isMatch) {
            bridge.moveLowerBridge();
            return;
        }
        bridge.cannotMoveLowerBridge();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(final String command) {
        return command.equals(InputView.Q_INPUT_CLIPPED_WORD);
    }
}
