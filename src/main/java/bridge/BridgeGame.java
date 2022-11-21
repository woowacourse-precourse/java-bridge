package bridge;

import bridge.Domain.UserBridges;
import bridge.Domain.Status;
import bridge.View.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static Status move(String moveTo, String space, UserBridges userBridges) {

        if(space.equals("U") && moveTo.equals("U")) {
            userBridges.saveMove("O", " ");
            return Status.RIGHT_CHOICE;
        }
        if(space.equals("U") && moveTo.equals("D")) {
            userBridges.saveMove(" ", "X");
            return Status.WRONG_CHOICE;
        }
        if(space.equals("D") && moveTo.equals("U")) {
            userBridges.saveMove("X", " ");
            return Status.WRONG_CHOICE;
        }
        if(space.equals("D") && moveTo.equals("D")) {
            userBridges.saveMove(" ", "O");
            return Status.RIGHT_CHOICE;
        }

        return Status.QUIT;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static Status retry(UserBridges userBridges) {
        String retry = InputView.readGameCommand();
        if (retry.equals("Q")) {
            return Status.QUIT;
        }

        userBridges.resetSpaces();
        return Status.PLAYING;
    }
}
