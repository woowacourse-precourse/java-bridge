package bridge.service;

import bridge.domain.BridgeGame;
import java.util.List;

public class BridgeUserInputComparator {

    //fail -> false
    public boolean compareUserInput(BridgeGame bridgeGame, String userMove) {
        List<String> bridge = bridgeGame.getBridge();
        List<String> user = bridgeGame.getUser();
        boolean prevBridgeRight = isPrevUserMoveRight(bridge, user);
        if (prevBridgeRight) {
            return isNextUserMoveRight(bridge, user, userMove);
        }
        return isPrevUserMoveRight(bridge, user, userMove);
    }

    private boolean isPrevUserMoveRight(List<String> bridge, List<String> user) {
        if (user.size() == 0) {
            return true;
        }
        return bridge.get(user.size() - 1).equals(user.get(user.size() - 1));
    }

    private boolean isNextUserMoveRight(List<String> bridge, List<String> user, String userMove) {
        user.add(userMove);
        return bridge.get(user.size() - 1).equals(userMove);
    }

    private boolean isPrevUserMoveRight(List<String> bridge, List<String> user, String userMove) {
        user.set(user.size() - 1, userMove);
        return bridge.get(user.size() - 1).equals(userMove);
    }

    public boolean isUserInBridgeGameEnd(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        List<String> user = bridgeGame.getUser();
        return isUserInLastBridge(bridge, user) && isUserRightInLastBridge(bridge, user);
    }

    private boolean isUserInLastBridge(List<String> bridge, List<String> user) {
        return user.size() == bridge.size();
    }

    private boolean isUserRightInLastBridge(List<String> bridge, List<String> user) {
        return user.get(user.size() - 1).equals(bridge.get(bridge.size() - 1));
    }

}
