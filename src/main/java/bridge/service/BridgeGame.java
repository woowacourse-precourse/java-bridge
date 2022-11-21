package bridge.service;

import bridge.domain.User;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static boolean move(String position, List<String> bridge, User user) {
            String moveResult = user.movePosition(bridge, position);
            if (moveResult.equals("O")) {
                user.increaseCount();
                return true;
            }
            return false;
    }

    public static boolean retry(String retryInput, User user) {
        if (retryInput.equals("R")) {
            user.increaseTryCount();
            return true;
        }
        return false;
    }

}
