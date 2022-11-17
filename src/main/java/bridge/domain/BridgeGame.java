package bridge.domain;

import static bridge.view.InputView.readMoving;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<Boolean> moveResult = new ArrayList<>();

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public void play() {
        for (int i = 0; i < bridge.size(); i++) {
            final boolean doesSuccessMove = move(i);
            if (!doesSuccessMove) {
                retry();
            }
        }
        // printResult

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int location) {
        String moveCommand = readMoving();
        if (canMove(location, moveCommand)) {
            moveResult.add(true);
            return true;
        }
        moveResult.add(false);
        return false;
    }

    private boolean canMove(int location, String moveCommand) {
        return moveCommand.equals(bridge.get(location));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
