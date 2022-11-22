package bridge;

import bridge.Domain.Key;
import bridge.Domain.UserBridges;
import bridge.Domain.State;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeGame() {}

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static State move(String moveTo, String space, UserBridges userBridges) {

        if (moveTo.equals(space)) {
            saveRightMove(moveTo, userBridges);
            return State.RIGHT_CHOICE;
        }

        saveWrongMove(moveTo, userBridges);
        return State.WRONG_CHOICE;
    }

    public static void saveRightMove(String moveTo, UserBridges userBridges) {

        if (moveTo.equals(Key.UP))
            userBridges.saveMove("O", " ");

        if (moveTo.equals(Key.DOWN))
            userBridges.saveMove(" ", "O");
    }

    public static void saveWrongMove(String moveTo, UserBridges userBridges) {

        if (moveTo.equals(Key.UP))
            userBridges.saveMove("X", " ");

        if (moveTo.equals(Key.DOWN))
            userBridges.saveMove(" ", "X");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void retry(UserBridges userBridges) {
        userBridges.resetSpaces();
    }
}
