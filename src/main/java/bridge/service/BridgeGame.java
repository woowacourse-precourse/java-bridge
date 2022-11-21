package bridge.service;

import bridge.domain.User;
import bridge.service.BridgeService;
import bridge.service.GameService;
import bridge.service.UserService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static boolean move(String position, List<String> bridge, User user) {
            boolean moveResult = canMove(position,bridge, user);

            if (!moveResult) {
                return true;
            }
            user.increaseCount();
            return false;
    }

    private static boolean canMove(String position, List<String> bridge, User user) {
        if (judgeMoving(bridge, user, position)) {
            return true;
        }
        return false;
    }

    public static boolean judgeMoving(List<String> bridge, User user, String userMoving) {
        String movingResult = user.canMove(bridge,userMoving);
        record(user,movingResult,userMoving);
        if(movingResult.equals("O")){
            return true;
        }
        return false;
    }

    public static void record(User user, String movingResult, String userMoving) {
        user.recordResult(movingResult,userMoving);
    }

    public static boolean retry(String retryInput, User user) {
        if (retryInput.equals("R")) {
            user.increaseTryCount();
            return true;
        }
        return false;
    }

}
